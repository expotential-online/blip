package blip.webservice.repo

import blip.model.AgentTypeId
import blip.model.agenttype.AgentType
import org.springframework.data.jpa.repository.JpaRepository

interface AgentTypeRepo : JpaRepository<AgentType, AgentTypeId>