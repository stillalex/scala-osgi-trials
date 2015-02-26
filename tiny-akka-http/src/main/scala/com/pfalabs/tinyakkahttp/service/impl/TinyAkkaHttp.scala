package com.pfalabs.tinyakkahttp.service.impl

import org.apache.felix.scr.annotations.{ Activate, Component, Deactivate }
import org.osgi.framework.BundleContext
import org.osgi.service.component.ComponentContext
import org.slf4j.{ Logger, LoggerFactory }

import akka.actor.ActorSystem
import akka.osgi.ActorSystemActivator

@Component(metatype = false, specVersion = "1.1")
class TinyAkkaHttp extends ActorSystemActivator {

  val log: Logger = LoggerFactory.getLogger(classOf[TinyAkkaHttp]);

  @Activate
  def activate(context: ComponentContext) {
    log.info("#activate {}.", context.getProperties)
    super.start(context.getBundleContext())
  }

  override def configure(context: BundleContext, actorSystem: ActorSystem) {
    // only if you need to make this actor system available
    registerService(context, actorSystem)
  }

  override def getActorSystemName(context: BundleContext): String = "tiny-actor-system"

  @Deactivate
  def deactivate(context: ComponentContext) = {
    super.stop(context.getBundleContext())
    log.info("#deactivate");
  }

}