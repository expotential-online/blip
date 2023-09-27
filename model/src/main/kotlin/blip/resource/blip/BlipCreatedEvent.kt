package blip.resource.blip

import blip.core.BlipId
import blip.core.BlipSummary
import blip.core.PersonId
import blip.core.event.AbstractEvent

data class BlipCreatedEvent(
  val id: BlipId,
  val summary: BlipSummary,
  val originatorId: PersonId
) : AbstractEvent()
