package blip.webservice.repo

import blip.model.BlipId
import blip.model.blip.Blip
import org.springframework.data.jpa.repository.JpaRepository

interface BlipRepo : JpaRepository<Blip, BlipId>