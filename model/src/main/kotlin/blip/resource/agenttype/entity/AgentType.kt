package blip.resource.agenttype.entity

import blip.core.Identifiable
import blip.resource.agent.entity.Agent
import blip.resource.agenttype.AgentTypeDescription
import blip.resource.agenttype.AgentTypeId
import blip.resource.agenttype.AgentTypeName
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.OneToMany

@Entity
class AgentType(

  var name: AgentTypeName?,

  var description: AgentTypeDescription?,

  @OneToMany
  var agents: Collection<Agent>? = null,

  @Id
  @GeneratedValue
  override var id: AgentTypeId? = null
) : Identifiable<AgentTypeId>