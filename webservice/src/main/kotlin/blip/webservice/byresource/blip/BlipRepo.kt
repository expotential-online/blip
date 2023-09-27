package blip.webservice.byresource.blip

import blip.core.BlipId
import blip.core.BlipList
import blip.resource.blip.Blip
import blip.resource.person.Person
import blip.webservice.Repo

interface BlipRepo : Repo<Blip, BlipId> {
  fun findByOriginator(person: Person): BlipList
}