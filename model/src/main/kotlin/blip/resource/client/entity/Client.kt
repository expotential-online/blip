package blip.resource.client.entity

import blip.core.Identifiable
import blip.resource.client.ClientDescription
import blip.resource.client.ClientId
import blip.resource.client.ClientName
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id

@Entity
class Client(
  var name: ClientName?,
  var description: ClientDescription?,
  @Id @GeneratedValue override var id: ClientId? = null
) : Identifiable<ClientId>