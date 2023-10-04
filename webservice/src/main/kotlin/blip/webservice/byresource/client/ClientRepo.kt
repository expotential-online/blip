package blip.webservice.byresource.client

import blip.resource.client.ClientId
import blip.resource.client.ClientName
import blip.resource.client.entity.Client
import blip.webservice.Repo

interface ClientRepo : Repo<Client, ClientId> {
  fun existsByNameIgnoreCase(name: ClientName): Boolean
  fun getClientByNameIgnoreCase(name: ClientName): Client?
}