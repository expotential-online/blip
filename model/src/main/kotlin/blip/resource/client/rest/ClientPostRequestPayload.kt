package blip.resource.client.rest

import blip.resource.client.ClientDescription
import blip.resource.client.ClientName

data class ClientPostRequestPayload(
  val name: ClientName,
  val description: ClientDescription
)
