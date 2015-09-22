package com.pfalabs.tinyoak

import org.apache.felix.scr.annotations.Component
import org.apache.felix.scr.annotations.Properties
import org.apache.felix.scr.annotations.Property
import org.apache.felix.scr.annotations.Reference
import org.apache.felix.scr.annotations.ReferencePolicy.STATIC
import org.apache.felix.scr.annotations.ReferencePolicyOption.GREEDY
import org.apache.felix.scr.annotations.Service
import org.apache.jackrabbit.oak.api.ContentRepository
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import javax.jcr.SimpleCredentials
import javax.servlet.Filter
import javax.servlet.FilterChain
import javax.servlet.FilterConfig
import javax.servlet.ServletRequest
import javax.servlet.ServletResponse
import org.apache.jackrabbit.api.security.authentication.token.TokenCredentials
import com.google.common.io.Closer

@Component(immediate = true, metatype = false, specVersion = "1.2")
@Service(value = Array(classOf[Filter]))
@Properties(Array(new Property(name = "pattern", value = Array("/tinyoak"))))
class Tiny extends Filter {

  val log: Logger = LoggerFactory.getLogger(classOf[Tiny])

  @Reference
  val repo: ContentRepository = null

  // -------- Filter -----

  override def init(config: FilterConfig) = log.info("Init with config [{}]", config)

  override def destroy() = log.info("Destroyed filter")

  override def doFilter(req: ServletRequest, res: ServletResponse, chain: FilterChain) {
    res.setContentType("text/plain")
    val out = res.getWriter()
    out.println("Request = " + req)
    out.println("Repo = " + repo)

    val sc = new SimpleCredentials("admin", "admin".toCharArray())
    sc.setAttribute(".token", "")

    val closer = Closer.create
    try {
      val cs = repo.login(sc, null)
      closer.register(cs)

      out.println("Admin Session = " + cs);
      out.println("AuthInfo = " + cs.getAuthInfo());
      out.println("token = " + sc.getAttribute(".token"));
      val token = new TokenCredentials(sc.getAttribute(".token").toString());
      val tokenSession = repo.login(token, null);
      closer.register(tokenSession)

      out.println("Token Session = " + tokenSession);
    } finally {
      closer.close()
    }

  }
}