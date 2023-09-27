package blip.resource.blip

import blip.resource.person.Person
import java.security.Principal

fun CreateBlipCommand.toBlip(person: Person): Blip = with(this) {
  Blip(summary, person, null)
}

fun Blip.toBlipCreatedEvent(): BlipCreatedEvent = with(this) {
  BlipCreatedEvent(id!!, summary!!, originator!!.id!!)
}

fun BlipPostPayload.toCreateBlipCommand(principal: Principal): CreateBlipCommand = with(this) {
  CreateBlipCommand(summary, principal)
}