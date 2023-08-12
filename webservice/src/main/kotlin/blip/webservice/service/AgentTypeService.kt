package blip.webservice.service

import blip.model.AgentTypeId
import blip.model.agenttype.AgentType
import blip.model.agenttype.AgentTypeDto
import blip.model.agenttype.AgentTypeMapper
import blip.webservice.repo.AgentTypeRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class AgentTypeService(@Autowired private val repo: AgentTypeRepo) :
  AbstractModelService<AgentType, AgentTypeId, AgentTypeDto>(repo, AgentTypeMapper)