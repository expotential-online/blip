package blip.resource.client.rest

import blip.resource.client.ClientDescription
import blip.resource.client.ClientId
import blip.resource.client.ClientName

data class ClientGetByIdResponsePayload(
  val id: ClientId,
  val name: ClientName,
  val description: ClientDescription
)
