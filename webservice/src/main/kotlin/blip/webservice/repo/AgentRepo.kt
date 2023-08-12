package blip.webservice.repo

import blip.model.AgentId
import blip.model.agent.Agent
import org.springframework.data.jpa.repository.JpaRepository

interface AgentRepo : JpaRepository<Agent, AgentId>