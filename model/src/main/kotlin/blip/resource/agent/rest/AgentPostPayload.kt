package blip.resource.agent.rest

import blip.resource.agent.AgentDescription
import blip.resource.agent.AgentId
import blip.resource.agent.AgentName
import blip.resource.agent.AgentUserName
import blip.resource.agenttype.AgentTypeId

data class AgentPostPayload(
  val id: AgentId,
  val name: AgentName,
  val description: AgentDescription,
  val userName: AgentUserName,
  val typeId: AgentTypeId
)
