package com.pfalabs.spray.osgi

import org.apache.felix.scr.annotations.Activate
import org.apache.felix.scr.annotations.Component
import org.apache.felix.scr.annotations.Deactivate
import org.apache.felix.scr.annotations.Reference
import org.osgi.framework.BundleContext
import org.osgi.service.component.ComponentContext
import org.osgi.service.http.HttpContext
import org.osgi.service.http.HttpService
import org.slf4j.Logger
import org.slf4j.LoggerFactory

import com.pfalabs.spray.TinySprayActor
import com.typesafe.config.Config
import com.typesafe.config.ConfigFactory

import akka.actor.ActorSystem
import akka.actor.Props
import akka.osgi.ActorSystemActivator
import javax.servlet.ServletContext
import spray.http.Uri
import spray.servlet.ConnectorSettings
import spray.servlet.Initializer.ServiceActorAttrName
import spray.servlet.Initializer.SettingsAttrName
import spray.servlet.Initializer.SystemAttrName
import spray.servlet.Servlet30ConnectorServlet

@Component(specVersion = "1.1", immediate = true)
class ActivatorHttp extends ActorSystemActivator {

  val PATH = "/"

  // https://github.com/akka/akka/blob/v2.2.3/akka-samples/akka-sample-osgi-dining-hakkers/core/src/main/scala/akka/sample/osgi/activation/Activator.scala
  // https://groups.google.com/forum/#!msg/spray-user/5ylouDRAj-o/Xxnu75SWkmEJ

  val logger: Logger = LoggerFactory.getLogger(classOf[ActivatorHttp]);

  @Reference
  val http: HttpService = null;

  var httpContext: HttpContext = null;

  @Activate
  def activate(context: ComponentContext) {
    httpContext = http.createDefaultHttpContext()
    super.start(context.getBundleContext())
  }

  override def configure(context: BundleContext, actorSystem: ActorSystem) {
    //TODO unregister?
    http.registerResources("/css", "/web/css", httpContext);

    //TODO <async-supported>true</async-supported>
    http.registerServlet(PATH, newSprayServlet(actorSystem), null, httpContext)
    logger.info(s"... registered servlet under '${PATH}'")
  }

  // ---- SPRAY ---

  def newSprayServlet(actorSystem: ActorSystem) = new Servlet30ConnectorServlet() {
    override def init() {
      initSpray(getServletContext(), actorSystem)
      super.init();
    }
    override def destroy() {
      super.destroy();
    }
  }

  def initSpray(ctx: ServletContext, system: ActorSystem) {
    import spray.servlet.Initializer._

    val settings0 = ConnectorSettings(system.settings.config)
    val settings =
      if (settings0.rootPath == Uri.Path("AUTO")) {
        settings0.copy(rootPath = Uri.Path(ctx.getContextPath))
      } else settings0
    ctx.setAttribute(SettingsAttrName, settings)

    val serviceActor = system.actorOf(Props[TinySprayActor], "serviceActor")
    ctx.setAttribute(SystemAttrName, system)
    ctx.setAttribute(ServiceActorAttrName, serviceActor)
  }

  override def getActorSystemConfiguration(context: BundleContext): Config = {
    val orgConfig = ConfigFactory.load(classOf[ActivatorHttp].getClassLoader)
    val sprayConfig = ConfigFactory.load(classOf[spray.routing.HttpService].getClassLoader)
    orgConfig.withFallback(sprayConfig)
  }

  override def getActorSystemName(context: BundleContext): String = "spray-testies-activator"

  @Deactivate
  def deactivate(context: ComponentContext) = {
    logger.info("... went to sleep");
    http.unregister(PATH)
    super.stop(context.getBundleContext())
  }

}