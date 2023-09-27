package blip.resource.agenttype

import blip.archive.model.Constraints
import blip.core.AgentTypeName
import blip.core.command.AbstractCommand
import jakarta.validation.constraints.Size

data class RegisterAgentTypeCommand(
  @get:Size(min = Constraints.AgentTypeNameMinLength, max = Constraints.AgentTypeNameMaxLength)
  val name: AgentTypeName
) : AbstractCommand()