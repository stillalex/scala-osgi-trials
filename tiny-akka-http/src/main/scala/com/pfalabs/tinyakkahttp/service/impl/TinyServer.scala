package com.pfalabs.tinyakkahttp.service.impl

import org.apache.felix.scr.annotations.{ Activate, Component, Deactivate, Property, Reference }
import org.osgi.service.component.ComponentContext
import org.slf4j.{ Logger, LoggerFactory }

import akka.actor.ActorSystem
import akka.http.Http
import akka.http.Http.ServerBinding
import akka.http.marshallers.xml.ScalaXmlSupport.defaultNodeSeqMarshaller
import akka.http.marshalling.ToResponseMarshallable.apply
import akka.http.server.Directive.{ addByNameNullaryApply, addDirectiveApply }
import akka.http.server.Directives.{ HttpBasicAuthentication, complete, enhanceRouteWithConcatenation, get, path, segmentStringToPathMatcher }
import akka.http.server.RouteResult.route2HandlerFlow
import akka.http.server.directives.AuthenticationDirectives.{ HttpBasicAuthenticator, UserCredentials }
import akka.stream.ActorFlowMaterializer
import akka.stream.scaladsl.MaterializedMap

@Component(metatype = false, specVersion = "1.2")
class TinyServer {

  val log: Logger = LoggerFactory.getLogger(classOf[TinyServer]);

  @Reference
  val system: ActorSystem = null

  @Property(name = "port", description = "Http port", intValue = Array(8080))
  val PORT_CONFIG = "port"

  var binding: Option[ServerBinding] = None
  var mm: Option[MaterializedMap] = None

  @Activate
  def activate(context: ComponentContext) {
    log.info("#activate {}.", context.getProperties)
    startHttp(readPortConfig(context, 8080))
  }

  def readPortConfig(context: ComponentContext, default: Int): Int = {
    if (context.getProperties().get(PORT_CONFIG) != null) {
      return context.getProperties().get(PORT_CONFIG).toString().toInt
    }
    default
  }

  def startHttp(port: Int) {

    import system.dispatcher
    //TODO check this
    implicit val actorSystem = system
    implicit val materializer = ActorFlowMaterializer()

    import akka.http.server.Directives._

    def auth =
      HttpBasicAuthenticator.provideUserName {
        case p @ UserCredentials.Provided(name) ⇒ p.verifySecret(name + "-password")
        case _                                  ⇒ false
      }

    val http = Http().bind(interface = "localhost", port = port)
    binding = Some(http)
    val materializedMap = http startHandlingWith {
      get {
        path("") {
          complete(index)
        } ~
          path("secure") {
            HttpBasicAuthentication("My very secure site")(auth) { user ⇒
              complete(<html><body>Hello <b>{ user }</b>. Access has been granted!</body></html>)
            }
          } ~
          path("ping") {
            complete("PONG!")
          } ~
          path("crash") {
            complete(sys.error("BOOM!"))
          }
      }
    }
    mm = Some(materializedMap)
    log.info("server online at localhost:{}", port)
  }

  lazy val index =
    <html>
      <body>
        <h1>Say hello to <i>akka-http-core</i>!</h1>
        <p>Defined resources:</p>
        <ul>
          <li><a href="/ping">/ping</a></li>
          <li><a href="/secure">/secure</a> Use any username and '&lt;username&gt;-password' as credentials</li>
          <li><a href="/crash">/crash</a></li>
        </ul>
      </body>
    </html>

  @Deactivate
  def deactivate(context: ComponentContext) = {
    import system.dispatcher
    for (
      b ← binding;
      m ← mm
    ) {
      b.unbind(m).onComplete(_ ⇒ log.info("server is down."))
    }
    log.info("#deactivate");
  }

}