package com.pfalabs.tinyfilter

import org.apache.felix.scr.annotations.{ Component, Properties, Service }
import org.slf4j.{ Logger, LoggerFactory }
import javax.servlet.{ Filter, FilterChain, FilterConfig, ServletRequest, ServletResponse }
import org.apache.felix.scr.annotations.Property
import com.pfalabs.tinyfilter.service.TinyService
import org.apache.felix.scr.annotations.Reference

@Component(immediate = true, specVersion = "1.2")
@Service(value = Array(classOf[Filter]))
@Properties(Array(
  new Property(name = "osgi.http.whiteboard.context.select", value = Array("(osgi.http.whiteboard.context.name=org.osgi.service.http)")),
  new Property(name = "osgi.http.whiteboard.filter.pattern", value = Array("/t")),
  new Property(name = "osgi.http.whiteboard.filter.name", value = Array("TinyFilter2"))))
class TinyFilter2 extends Filter {

  val log: Logger = LoggerFactory.getLogger(classOf[TinyFilter2]);

  @Reference
  val tiny: TinyService = null;

  // -------- Filter -----

  override def init(config: FilterConfig) = log.info("Init with config [{}]", config);

  override def destroy() = log.info("Destroyed filter");

  override def doFilter(req: ServletRequest, res: ServletResponse, chain: FilterChain) {
    log.info("request! {}", req);

    //    res.setContentType("text/plain");
    //    val out = res.getWriter();
    //    out.println("Request = " + req);
    //    out.println("Service = " + tiny);

    chain.doFilter(req, res)

  }
}