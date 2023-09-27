package blip.resource.agenttype

import blip.core.AgentTypeId
import blip.core.AgentTypeName
import blip.core.event.AbstractEvent

data class AgentTypeRegisteredEvent(
  val id: AgentTypeId,
  val name: AgentTypeName
) : AbstractEvent()