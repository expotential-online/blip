package blip.webservice.byresource.agenttype

import blip.resource.agenttype.AgentTypeId
import blip.resource.agenttype.AgentTypeName
import blip.resource.agenttype.entity.AgentType
import blip.webservice.Repo

interface AgentTypeRepo : Repo<AgentType, AgentTypeId> {
  fun existsAgentTypeByNameEqualsIgnoreCase(name: AgentTypeName): Boolean
  fun findByNameEqualsIgnoreCase(name: AgentTypeName): AgentType?
}