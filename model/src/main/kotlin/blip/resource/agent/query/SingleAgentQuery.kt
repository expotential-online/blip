package blip.resource.agent.query

import blip.core.query.AbstractQuery
import blip.resource.agent.AgentId

data class SingleAgentQuery(
  val id: AgentId
) : AbstractQuery()
