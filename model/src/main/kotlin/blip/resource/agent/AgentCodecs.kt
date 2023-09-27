package blip.resource.agent

import blip.resource.agenttype.AgentType

fun AgentPostPayload.toRegisterAgentCommand(): RegisterAgentCommand = with(this) {
  RegisterAgentCommand(name, typeName)
}

fun RegisterAgentCommand.toAgentWithType(agentType: AgentType): Agent = with(this) {
  Agent(name, agentType)
}

fun Agent.toAgentRegisteredEvent(): AgentRegisteredEvent = with(this) {
  AgentRegisteredEvent(id!!, name!!, type!!.id!!)
}