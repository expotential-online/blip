package blip.resource.agent

import blip.core.AgentId
import blip.core.AgentName
import blip.core.Identifiable
import blip.resource.agenttype.AgentType
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne

@Entity
class Agent(

  var name: AgentName?,

  @ManyToOne
  var type: AgentType?,

  @Id
  @GeneratedValue
  override var id: AgentId? = null

) : Identifiable<AgentId>