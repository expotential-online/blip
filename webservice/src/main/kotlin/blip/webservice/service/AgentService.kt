package blip.webservice.service

import blip.model.AgentId
import blip.model.agent.Agent
import blip.model.agent.AgentDto
import blip.model.agent.AgentMapper
import blip.webservice.repo.AgentRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class AgentService(@Autowired private val repo: AgentRepo) :
  AbstractModelService<Agent, AgentId, AgentDto>(repo, AgentMapper)