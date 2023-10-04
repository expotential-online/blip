package blip.resource.client.query

import blip.core.query.AbstractQuery
import blip.resource.client.ClientName

data class ClientByNameQuery(
  val name: ClientName
) : AbstractQuery()
