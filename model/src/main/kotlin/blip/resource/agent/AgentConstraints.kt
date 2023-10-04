package blip.resource.agent

typealias AgentDescription = String
typealias AgentId = Long
typealias AgentName = String
typealias AgentUserName = String

object AgentConstraints {
  const val AgentNameMinLength = 4
  const val AgentNameMaxLength = 64
  const val AgentDescriptionMinLength = 16
  const val AgentDescriptionMaxLength = 256
  const val AgentUserNameMinLength = 4
  const val AgentUserNameMaxLength = 64

}