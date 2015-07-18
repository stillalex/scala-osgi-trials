package com.pfalabs.tinyakkahttp.service.impl

import scala.concurrent.Future

import org.apache.felix.scr.annotations.{ Activate, Component, Deactivate, Property, Reference }
import org.osgi.service.component.ComponentContext
import org.slf4j.{ Logger, LoggerFactory }

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.Http.ServerBinding
import akka.http.scaladsl.marshallers.xml.ScalaXmlSupport.defaultNodeSeqMarshaller
import akka.http.scaladsl.marshalling.ToResponseMarshallable.apply
import akka.http.scaladsl.server.Directive.{ addByNameNullaryApply, addDirectiveApply }
import akka.http.scaladsl.server.Directives.{ authenticateBasicPF, complete, enhanceRouteWithConcatenation, get, logRequestResult, path, segmentStringToPathMatcher }
import akka.http.scaladsl.server.RouteResult.route2HandlerFlow
import akka.http.scaladsl.server.directives.LoggingMagnet.forRequestResponseFromMarker
import akka.http.scaladsl.server.directives.SecurityDirectives.AuthenticatorPF
import akka.http.scaladsl.server.directives.UserCredentials
import akka.stream.ActorMaterializer

@Component(metatype = false, specVersion = "1.2")
class TinyServer {

  val log: Logger = LoggerFactory.getLogger(classOf[TinyServer]);

  @Reference
  val system: ActorSystem = null

  @Property(name = "port", description = "Http port", intValue = Array(8080))
  val PORT_CONFIG = "port"

  var binding: Option[Future[ServerBinding]] = None

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
    implicit val materializer = ActorMaterializer()

    def auth: AuthenticatorPF[String] = {
      case p @ UserCredentials.Provided(name) if p.verifySecret(name + "-password") ⇒ name
    }

    val routes = {
      logRequestResult("akka-http-microservice") {
        get {
          path("") {
            complete(index)
          } ~
            path("secure") {
              authenticateBasicPF("My very secure site", auth) { user ⇒
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
    }

    val http = Http().bindAndHandle(routes, "localhost", port)
    binding = Some(http)
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
      b ← binding
    ) {
      b.flatMap(_.unbind()).onComplete(_ ⇒ log.info("server is down."))
    }
    log.info("#deactivate");
  }

}