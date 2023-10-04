package blip.resource.client.query

import blip.core.query.AbstractQuery
import blip.resource.client.ClientId

data class ClientByIdQuery(
  val id: ClientId
) : AbstractQuery()
