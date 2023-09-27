package blip.resource.agent

import blip.core.AgentName
import blip.core.AgentTypeName

data class AgentPostPayload(
  val name: AgentName,
  val typeName: AgentTypeName
)
