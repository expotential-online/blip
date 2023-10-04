package blip.resource.agent.rest

import blip.core.CompleteUrl
import blip.resource.agent.AgentDescription
import blip.resource.agent.AgentId
import blip.resource.agent.AgentName
import blip.resource.agent.AgentUserName

data class AgentGetResponse(
  val id: AgentId,
  val name: AgentName,
  val description: AgentDescription,
  val userName: AgentUserName,
  val typeUrl: CompleteUrl
)
