package blip.model.agenttype

import blip.model.AgentTypeId
import blip.model.AgentTypeName
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class AgentType(

  var name: AgentTypeName?,

  @Id
  @GeneratedValue
  var id: AgentTypeId? = null
)