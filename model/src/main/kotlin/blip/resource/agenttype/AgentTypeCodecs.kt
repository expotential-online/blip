package blip.resource.agenttype

fun AgentType.toAgentTypeRegisteredEvent(): AgentTypeRegisteredEvent = with(this) {
  AgentTypeRegisteredEvent(id!!, name!!)
}

fun AgentType.toAgentTypeGetResponse(): AgentTypeGetResponse = with(this) {
  AgentTypeGetResponse(name!!)
}

fun RegisterAgentTypeCommand.toAgentType(): AgentType = with(this) {
  AgentType(name)
}

fun AgentTypePostPayload.toRegisterAgentTypeCommand(): RegisterAgentTypeCommand = with(this) {
  RegisterAgentTypeCommand(name)
}