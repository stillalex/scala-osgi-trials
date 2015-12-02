package com.pfalabs.tinyfilter

import org.osgi.service.component.annotations.Component
import javax.servlet.Servlet
import javax.servlet.http.HttpServlet
import org.osgi.service.component.annotations.ServiceScope.SINGLETON
import org.slf4j.Logger
import org.slf4j.LoggerFactory

@Component(service = Array(classOf[Servlet]), immediate = true, scope = SINGLETON,
  property = {
    Array("osgi.http.whiteboard.servlet.pattern=/*",
      "osgi.http.whiteboard.filter.asyncSupported=true",
      "osgi.http.whiteboard.context.select=(osgi.http.whiteboard.context.name=org.osgi.service.http)")
  })
class DefaultServlet extends HttpServlet {

  val log: Logger = LoggerFactory.getLogger(classOf[DefaultServlet])

  override def init() = log.info("#init")

}