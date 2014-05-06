package com.pfalabs.spray.templating

import org.fusesource.scalate.{ Binding, TemplateEngine }
import spray.http._
import spray.http.StatusCodes._
import spray.routing._
import MediaTypes._

trait ScalateSupport {

  // inspiration
  //  https://github.com/markkolich/spray-servlet-webapp/blob/master/src/main/scala/com/kolich/spray/templating/ScalateSupport.scala

  import Directives._

  private val templateEngine = new TemplateEngine
  templateEngine.allowReload = false
  templateEngine.classLoader = classOf[ScalateSupport].getClassLoader

  def render(uri: String, attributes: Map[String, Any] = Map.empty,
    extraBindings: Traversable[Binding] = Nil,
    mediaType: MediaType = `text/html`): Route = {
    respondWithMediaType(mediaType) {
      complete {
        templateEngine.layout(uri, attributes, extraBindings)
      }
    }
  }

  def renderError(errorCode: StatusCode, attributes: Map[String, Any] = Map.empty,
    extraBindings: Traversable[Binding] = Nil,
    mediaType: MediaType = `text/html`): Route = {
    errorCode match {
      case _ => render("/templates/error.ssp",
        attributes, extraBindings, mediaType)
    }
  }

}