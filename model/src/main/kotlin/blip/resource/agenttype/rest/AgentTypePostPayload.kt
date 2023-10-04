package blip.resource.agenttype.rest

import blip.resource.agenttype.AgentTypeDescription
import blip.resource.agenttype.AgentTypeName

data class AgentTypePostPayload(
  val name: AgentTypeName,
  val description: AgentTypeDescription
)
