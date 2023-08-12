package blip.webservice.service

import blip.model.BlipId
import blip.model.blip.Blip
import blip.model.blip.BlipDto
import blip.model.blip.BlipMapper
import blip.webservice.repo.BlipRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class BlipService(@Autowired private val repo: BlipRepo) :
  AbstractModelService<Blip, BlipId, BlipDto>(repo, BlipMapper)