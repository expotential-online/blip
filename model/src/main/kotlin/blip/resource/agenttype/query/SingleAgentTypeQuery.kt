package blip.resource.agenttype.query

import blip.core.query.AbstractQuery
import blip.resource.agenttype.AgentTypeId

data class SingleAgentTypeQuery(
  val id: AgentTypeId
) : AbstractQuery()
