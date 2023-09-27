package blip.resource.agenttype

import blip.core.AgentTypeId
import blip.core.query.AbstractQuery

data class SingleAgentTypeQuery(
  val id: AgentTypeId
) : AbstractQuery()
