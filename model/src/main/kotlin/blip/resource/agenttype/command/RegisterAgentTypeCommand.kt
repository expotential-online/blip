package blip.resource.agenttype.command

import blip.core.command.AbstractCommand
import blip.resource.agenttype.AgentTypeConstraints.AgentTypeDescriptionMaxLength
import blip.resource.agenttype.AgentTypeConstraints.AgentTypeDescriptionMinLength
import blip.resource.agenttype.AgentTypeConstraints.AgentTypeNameMaxLength
import blip.resource.agenttype.AgentTypeConstraints.AgentTypeNameMinLength
import blip.resource.agenttype.AgentTypeDescription
import blip.resource.agenttype.AgentTypeName
import jakarta.validation.constraints.Size

data class RegisterAgentTypeCommand(

  @get:Size(min = AgentTypeNameMinLength, max = AgentTypeNameMaxLength)
  val name: AgentTypeName,

  @get:Size(min = AgentTypeDescriptionMinLength, max = AgentTypeDescriptionMaxLength)
  val description: AgentTypeDescription

) : AbstractCommand()