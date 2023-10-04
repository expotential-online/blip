package blip.resource.agenttype

typealias AgentTypeDescription = String
typealias AgentTypeId = Long
typealias AgentTypeName = String

object AgentTypeConstraints {
  const val AgentTypeNameMinLength = 4
  const val AgentTypeNameMaxLength = 64
  const val AgentTypeDescriptionMinLength = 16
  const val AgentTypeDescriptionMaxLength = 256
}