package blip.resource.agent.command

import blip.core.command.AbstractCommand
import blip.resource.agent.AgentConstraints.AgentDescriptionMaxLength
import blip.resource.agent.AgentConstraints.AgentDescriptionMinLength
import blip.resource.agent.AgentConstraints.AgentNameMaxLength
import blip.resource.agent.AgentConstraints.AgentNameMinLength
import blip.resource.agent.AgentConstraints.AgentUserNameMaxLength
import blip.resource.agent.AgentConstraints.AgentUserNameMinLength
import blip.resource.agent.AgentDescription
import blip.resource.agent.AgentName
import blip.resource.agent.AgentUserName
import blip.resource.agenttype.AgentTypeId
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size

data class RegisterAgentCommand(

  @get:Size(min = AgentNameMinLength, max = AgentNameMaxLength)
  val name: AgentName,

  @get:Size(min = AgentDescriptionMinLength, max = AgentDescriptionMaxLength)
  val description: AgentDescription,

  @get:Size(min = AgentUserNameMinLength, max = AgentUserNameMaxLength)
  val userName: AgentUserName,

  @get:NotNull
  val typeId: AgentTypeId

) : AbstractCommand()
