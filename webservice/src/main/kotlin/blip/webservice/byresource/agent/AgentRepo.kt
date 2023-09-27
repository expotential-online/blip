package blip.webservice.byresource.agent

import blip.core.AgentId
import blip.core.AgentName
import blip.resource.agent.Agent
import blip.webservice.Repo

interface AgentRepo : Repo<Agent, AgentId> {
  fun existsAgentByNameEqualsIgnoreCase(name: AgentName): Boolean
}