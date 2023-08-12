package blip.model.agenttype

import blip.model.AgentTypeName
import blip.model.Constraints.AgentTypeNameMaxLength
import blip.model.Constraints.AgentTypeNameMinLength
import javax.validation.constraints.Size

data class AgentTypeDto(

  @get:Size(min = AgentTypeNameMinLength, max = AgentTypeNameMaxLength)
  val name: AgentTypeName
)
