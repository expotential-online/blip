package blip.resource.blip

import blip.archive.model.blipownership.BlipOwnership
import blip.core.BlipId
import blip.core.BlipSummary
import blip.core.Identifiable
import blip.resource.person.Person
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne
import jakarta.persistence.OneToOne

@Entity
class Blip(

  var summary: BlipSummary?,

  @ManyToOne
  var originator: Person?,

  @OneToOne
  var ownership: BlipOwnership?,

  @Id
  @GeneratedValue
  override var id: BlipId? = null
) : Identifiable<BlipId>