package blip.resource.client.event

import blip.core.event.AbstractEvent
import blip.resource.client.ClientDescription
import blip.resource.client.ClientId
import blip.resource.client.ClientName

data class ClientRegisteredEvent(
  val id: ClientId,
  val name: ClientName,
  val description: ClientDescription
) : AbstractEvent()
