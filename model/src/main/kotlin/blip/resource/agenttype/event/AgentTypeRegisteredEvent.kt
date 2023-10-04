package blip.resource.agenttype.event

import blip.core.event.AbstractEvent
import blip.resource.agenttype.AgentTypeDescription
import blip.resource.agenttype.AgentTypeId
import blip.resource.agenttype.AgentTypeName

data class AgentTypeRegisteredEvent(
  val id: AgentTypeId,
  val name: AgentTypeName,
  val description: AgentTypeDescription
) : AbstractEvent()