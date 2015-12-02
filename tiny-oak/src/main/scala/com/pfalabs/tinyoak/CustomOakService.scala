package com.pfalabs.tinyoak

import org.osgi.service.component.ComponentContext
import org.osgi.service.component.annotations.{ Activate, Component, Deactivate }

import com.pfalabs.soak.osgi.OakService

@Component(immediate = true)
class CustomOakService extends OakService {

  @Activate
  def activate(context: ComponentContext) = doActivate(context)

  @Deactivate
  def deactivate() = doDeactivate()
}