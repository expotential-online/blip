package blip.resource.agent.event

import blip.core.event.AbstractEvent
import blip.resource.agent.AgentDescription
import blip.resource.agent.AgentId
import blip.resource.agent.AgentName
import blip.resource.agent.AgentUserName
import blip.resource.agenttype.AgentTypeId

data class AgentRegisteredEvent(
  val id: AgentId,
  val name: AgentName,
  val description: AgentDescription,
  val userName: AgentUserName,
  val typeId: AgentTypeId
) : AbstractEvent()
