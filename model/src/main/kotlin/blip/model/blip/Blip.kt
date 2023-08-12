package blip.model.blip

import blip.model.BlipId
import blip.model.BlipSummary
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class Blip(

  var summary: BlipSummary?,

  @Id
  @GeneratedValue
  var id: BlipId? = null
)