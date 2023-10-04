package blip.resource.agenttype.codec

import blip.resource.agenttype.command.RegisterAgentTypeCommand
import blip.resource.agenttype.entity.AgentType
import blip.resource.agenttype.event.AgentTypeRegisteredEvent
import blip.resource.agenttype.rest.AgentTypeGetResponse
import blip.resource.agenttype.rest.AgentTypePostPayload

fun AgentTypePostPayload.toRegisterAgentTypeCommand(): RegisterAgentTypeCommand = with(this) {
  RegisterAgentTypeCommand(name, description)
}

fun RegisterAgentTypeCommand.toAgentType(): AgentType = with(this) {
  AgentType(name, description)
}

fun AgentType.toAgentTypeRegisteredEvent(): AgentTypeRegisteredEvent = with(this) {
  AgentTypeRegisteredEvent(id!!, name!!, description!!)
}

fun AgentType.toAgentTypeGetResponse(): AgentTypeGetResponse = with(this) {
  AgentTypeGetResponse(id!!, name!!, description!!)
}


