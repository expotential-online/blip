package blip.resource.agenttype

import blip.core.AgentId
import blip.core.AgentTypeId
import blip.core.AgentTypeName
import blip.core.Identifiable
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id

@Entity
class AgentType(

  var name: AgentTypeName?,

  @Id
  @GeneratedValue
  override var id: AgentTypeId? = null
) : Identifiable<AgentId>