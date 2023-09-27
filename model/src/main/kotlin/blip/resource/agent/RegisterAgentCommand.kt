package blip.resource.agent

import blip.archive.model.Constraints.AgentNameMaxLength
import blip.archive.model.Constraints.AgentNameMinLength
import blip.core.AgentName
import blip.core.AgentTypeName
import blip.core.command.AbstractCommand
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size

data class RegisterAgentCommand(

  @get:Size(min = AgentNameMinLength, max = AgentNameMaxLength)
  val name: AgentName,

  @get:NotNull
  val typeName: AgentTypeName
) : AbstractCommand()
