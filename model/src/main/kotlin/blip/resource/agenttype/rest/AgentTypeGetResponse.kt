package blip.resource.agenttype.rest

import blip.resource.agenttype.AgentTypeDescription
import blip.resource.agenttype.AgentTypeId
import blip.resource.agenttype.AgentTypeName

data class AgentTypeGetResponse(
  val id: AgentTypeId,
  val name: AgentTypeName,
  val description: AgentTypeDescription
)
