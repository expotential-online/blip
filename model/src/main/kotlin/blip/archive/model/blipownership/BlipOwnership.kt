package blip.archive.model.blipownership

import blip.core.BlipId
import blip.core.Identifiable
import blip.resource.blip.Blip
import blip.resource.person.Person
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.MapsId
import jakarta.persistence.OneToOne

@Entity
class BlipOwnership(

  @MapsId
  @JoinColumn(name = "id")
  @OneToOne
  var blip: Blip?,

  @ManyToOne
  var owner: Person?,

  @ManyToOne
  var nominator: Person?,

  var status: BlipOwnershipStatus?,

  @Id
  override var id: BlipId?
) : Identifiable<BlipId>