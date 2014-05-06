package com.pfalabs.spray

import akka.actor.Actor
import spray.routing._
import spray.http._
import MediaTypes._
import com.pfalabs.spray.templating.ScalateSupport

// we don't implement our route structure directly in the service actor because
// we want to be able to test it independently, without having to spin up an actor
class TinySprayActor extends Actor with TinySprayService {

  // the HttpService trait defines only one abstract member, which
  // connects the services environment to the enclosing actor or test
  def actorRefFactory = context

  // this actor only runs our route, but you could add
  // other things here, like request stream processing
  // or timeout handling
  def receive = runRoute(myRoute)
}

// this trait defines our service behavior independently from the service actor
trait TinySprayService extends HttpService with ScalateSupport {

  val myRoute =
    path("") {
      get { render("/templates/index.ssp") }
    }
}