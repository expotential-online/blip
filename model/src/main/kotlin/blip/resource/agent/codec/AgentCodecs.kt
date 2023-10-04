package blip.resource.agent.codec

import blip.core.CompleteUrl
import blip.resource.agent.command.RegisterAgentCommand
import blip.resource.agent.entity.Agent
import blip.resource.agent.event.AgentRegisteredEvent
import blip.resource.agent.rest.AgentGetResponse
import blip.resource.agent.rest.AgentPostPayload
import blip.resource.agenttype.entity.AgentType

fun AgentPostPayload.toRegisterAgentCommand(): RegisterAgentCommand = with(this) {
  RegisterAgentCommand(name, description, userName, typeId)
}

fun RegisterAgentCommand.toAgentWithType(agentType: AgentType): Agent = with(this) {
  Agent(name, description, userName, agentType)
}

fun Agent.toAgentRegisteredEvent(): AgentRegisteredEvent = with(this) {
  AgentRegisteredEvent(id!!, name!!, description!!, userName!!, type!!.id!!)
}

fun Agent.toAgentGetResponse(typeUrl: CompleteUrl): AgentGetResponse = with(this) {
  AgentGetResponse(id!!, name!!, description!!, userName!!, typeUrl)
}