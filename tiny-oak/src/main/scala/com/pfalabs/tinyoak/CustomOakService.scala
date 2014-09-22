package com.pfalabs.tinyoak

import org.apache.felix.scr.annotations.Activate
import org.apache.felix.scr.annotations.Component
import org.apache.felix.scr.annotations.Deactivate
import org.osgi.service.component.ComponentContext

import com.pfalabs.soak.osgi.OakService

@Component(immediate = true)
class CustomOakService extends OakService {

  @Activate
  def activate(context: ComponentContext) = doActivate(context)

  @Deactivate
  def deactivate() = doDeactivate()
}