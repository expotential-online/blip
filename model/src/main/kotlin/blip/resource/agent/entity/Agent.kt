package blip.resource.agent.entity

import blip.core.Identifiable
import blip.resource.agent.AgentDescription
import blip.resource.agent.AgentId
import blip.resource.agent.AgentName
import blip.resource.agent.AgentUserName
import blip.resource.agenttype.entity.AgentType
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne

@Entity
class Agent(

  var name: AgentName?,

  var description: AgentDescription?,

  var userName: AgentUserName?,

  @ManyToOne
  var type: AgentType?,

  @Id
  @GeneratedValue
  override var id: AgentId? = null

) : Identifiable<AgentId>