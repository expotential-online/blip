package blip.resource.person

import blip.core.PersonId
import blip.core.PersonPrincipalName
import blip.core.event.AbstractEvent

data class PersonRegisteredEvent(
  val id: PersonId,
  val principalName: PersonPrincipalName
) : AbstractEvent()
