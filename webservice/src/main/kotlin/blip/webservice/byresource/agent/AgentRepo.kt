package blip.webservice.byresource.agent

import blip.resource.agent.AgentId
import blip.resource.agent.AgentName
import blip.resource.agent.entity.Agent
import blip.webservice.Repo

interface AgentRepo : Repo<Agent, AgentId> {
  fun existsAgentByNameEqualsIgnoreCase(name: AgentName): Boolean
}