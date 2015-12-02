package com.pfalabs.tinyfilter.service.impl

import java.util.Calendar

import org.osgi.service.component.ComponentContext
import org.osgi.service.component.annotations.{ Activate, Component, Deactivate }
import org.slf4j.{ Logger, LoggerFactory }

import com.pfalabs.tinyfilter.service.TinyService

@Component(service = Array(classOf[TinyService]), immediate = true)
class TinyServiceImpl extends TinyService {

  val log: Logger = LoggerFactory.getLogger(classOf[TinyServiceImpl])

  def doSomething() = "Time is " + Calendar.getInstance().getTime()

  @Activate
  def activate(context: ComponentContext) = log.info(s"#activate $context")

  @Deactivate
  def deactivate() = log.info("#deactivate")

}