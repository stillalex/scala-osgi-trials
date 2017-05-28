package com.pfalabs.tinyfilter

import org.osgi.service.component.annotations.{ Component, Reference }
import org.slf4j.{ Logger, LoggerFactory }

import com.pfalabs.tinyfilter.service.TinyService

import javax.servlet.{ Filter, FilterChain, FilterConfig, ServletRequest, ServletResponse }

@Component(service = Array(classOf[Filter]), immediate = true, property = {
  Array("osgi.http.whiteboard.filter.pattern=/tiny",
    "osgi.http.whiteboard.filter.asyncSupported=true",
    "osgi.http.whiteboard.context.select=(osgi.http.whiteboard.context.name=org.osgi.service.http)")
})
class Tiny extends Filter {

  val log: Logger = LoggerFactory.getLogger(classOf[Tiny])

  var tiny: Option[TinyService] = None

  // -------- Filter -----

  override def init(config: FilterConfig) = log.info(s"#init $tiny")

  override def destroy() = log.info("#destroy")

  override def doFilter(req: ServletRequest, res: ServletResponse, chain: FilterChain) {
    res.setContentType("text/plain")
    val out = res.getWriter()
    out.println("Request = " + req)
    out.println("Service = " + tiny.map(_.doSomething).getOrElse("No Service Available!"))
  }

  @Reference
  def setService(t: TinyService) {
    log.info(s"#setService $t")
    tiny = Some(t)
  }

  def unsetService(t: TinyService) {
    log.info(s"#unsetService $t")
    tiny = None
  }

  //TODO
  //  def updatedService(ref: Map[String, _]) {
  //    log.info(s"#updatedService $ref")
  //  }

}