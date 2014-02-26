package com.pfalabs.tinyfilter.service.impl

import java.util.Calendar
import org.apache.felix.scr.annotations.{ Activate, Component, Deactivate, Service }
import com.pfalabs.tinyfilter.service.TinyService
import org.osgi.service.component.ComponentContext
import org.slf4j.{ Logger, LoggerFactory }

@Component(metatype = false, specVersion = "1.1")
@Service(value = Array(classOf[TinyService]))
class TinyServiceImpl extends TinyService {

  val log: Logger = LoggerFactory.getLogger(classOf[TinyServiceImpl]);

  def doSomething() = "Time is " + Calendar.getInstance().getTime();

  @Activate
  def activate(context: ComponentContext) {
    log.info("TinyServiceImpl is alive [{}]", context);
  }

  @Deactivate
  def deactivate() = log.info("TinyServiceImpl went to sleep");

}