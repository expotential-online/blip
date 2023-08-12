package blip.model.agent

import blip.model.AgentName
import blip.model.Constraints.AgentNameMaxLength
import blip.model.Constraints.AgentNameMinLength
import javax.validation.constraints.Size

data class AgentDto(

  @get:Size(min = AgentNameMinLength, max = AgentNameMaxLength)
  val name: AgentName
)
