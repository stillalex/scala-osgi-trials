package com.pfalabs.tinyfilter

import org.apache.felix.scr.annotations.{ Component, Properties, Service }
import org.slf4j.{ Logger, LoggerFactory }
import javax.servlet.{ Filter, FilterChain, FilterConfig, ServletRequest, ServletResponse }
import org.apache.felix.scr.annotations.Property
import com.pfalabs.tinyfilter.service.TinyService
import org.apache.felix.scr.annotations.Reference

@Component(immediate = true, metatype = false, specVersion = "1.1")
@Service(value = Array(classOf[Filter]))
@Properties(Array(new Property(name = "pattern", value = Array("/tiny"))))
class Tiny extends Filter {

  val log: Logger = LoggerFactory.getLogger(classOf[Tiny]);

  @Reference
  val tiny: TinyService = null;

  // -------- Filter -----

  override def init(config: FilterConfig) = log.info("Init with config [{}]", config);

  override def destroy() = log.info("Destroyed filter");

  override def doFilter(req: ServletRequest, res: ServletResponse, chain: FilterChain) {
    res.setContentType("text/plain");
    val out = res.getWriter();
    out.println("Request = " + req);
    out.println("Service = " + tiny.doSomething);
  }
}