package blip.resource.agent

import blip.core.AgentId
import blip.core.AgentName
import blip.core.AgentTypeId
import blip.core.event.AbstractEvent

data class AgentRegisteredEvent(
  val id: AgentId,
  val name: AgentName,
  val typeId: AgentTypeId
) : AbstractEvent()
