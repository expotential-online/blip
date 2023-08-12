package blip.model.agent

import blip.model.AgentId
import blip.model.AgentName
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class Agent(

  var name: AgentName?,

  @Id
  @GeneratedValue
  var id: AgentId? = null
)