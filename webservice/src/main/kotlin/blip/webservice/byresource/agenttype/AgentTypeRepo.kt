package blip.webservice.byresource.agenttype

import blip.core.AgentTypeId
import blip.core.AgentTypeName
import blip.resource.agenttype.AgentType
import blip.webservice.Repo

interface AgentTypeRepo : Repo<AgentType, AgentTypeId> {
  fun existsAgentTypeByNameEqualsIgnoreCase(name: AgentTypeName): Boolean
  fun findByNameEqualsIgnoreCase(name: AgentTypeName): AgentType?
}