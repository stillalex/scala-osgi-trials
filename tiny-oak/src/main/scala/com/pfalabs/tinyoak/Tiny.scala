package com.pfalabs.tinyoak

import org.apache.jackrabbit.oak.api.ContentRepository

import org.osgi.service.component.annotations.{ Component, Reference }
import org.slf4j.{ Logger, LoggerFactory }

import com.google.common.io.Closer

import javax.jcr.SimpleCredentials
import javax.servlet.{ Filter, FilterChain, FilterConfig, ServletRequest, ServletResponse }
import org.apache.jackrabbit.api.security.authentication.token.TokenCredentials

@Component(service = Array(classOf[Filter]), immediate = true, property = {
  Array("osgi.http.whiteboard.filter.pattern=/tinyoak",
    "osgi.http.whiteboard.filter.asyncSupported=true",
    "osgi.http.whiteboard.context.select=(osgi.http.whiteboard.context.name=org.osgi.service.http)")
})
class Tiny extends Filter {

  val log: Logger = LoggerFactory.getLogger(classOf[Tiny])

  var repository: Option[ContentRepository] = None

  // -------- Filter -----

  override def init(config: FilterConfig) = log.info("Init with config [{}]", config)

  override def destroy() = log.info("Destroyed filter")

  override def doFilter(req: ServletRequest, res: ServletResponse, chain: FilterChain) {
    res.setContentType("text/plain")
    val out = res.getWriter()
    out.println("Request = " + req)
    out.println("Repo = " + repository)

    val sc = new SimpleCredentials("admin", "admin".toCharArray())
    sc.setAttribute(".token", "")

    val closer = Closer.create
    try {
      repository.map {
        r ⇒

          val cs = r.login(sc, null)
          closer.register(cs)

          out.println("Admin Session = " + cs)
          out.println("AuthInfo = " + cs.getAuthInfo())
          out.println("token = " + sc.getAttribute(".token"))

          val token = new TokenCredentials(sc.getAttribute(".token").toString())
          val tokenSession = r.login(token, null)
          closer.register(tokenSession)
          out.println("Token Session = " + tokenSession)
      }
    } finally {
      closer.close()
    }
  }

  @Reference(name = "repository")
  def setContentRepository(r: ContentRepository) {
    repository = Some(r)
  }

  def unsetContentRepository(r: ContentRepository) {
    repository = None
  }

}