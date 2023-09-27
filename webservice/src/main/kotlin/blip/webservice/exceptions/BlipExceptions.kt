package blip.webservice.exceptions

import blip.resource.BlipResourceType
import jakarta.persistence.EntityExistsException
import jakarta.persistence.EntityNotFoundException

object BlipExceptions {

  fun resourceAlreadyExistsException(
    resource: BlipResourceType,
    propertyName: String,
    propertyValue: String
  ): EntityExistsException =
    EntityExistsException(resourceAlreadyExistsMessage(resource, propertyName, propertyValue))

  private fun resourceAlreadyExistsMessage(
    resource: BlipResourceType,
    propertyName: String,
    propertyValue: String
  ): String =
    "${resource.capitalisedSingularName} already exists with $propertyName [$propertyValue]"

  fun resourceDoesNotExistException(
    resource: BlipResourceType,
    propertyName: String,
    propertyValue: String
  ): EntityNotFoundException =
    EntityNotFoundException(resourceDoesNotExistMessage(resource, propertyName, propertyValue))

  private fun resourceDoesNotExistMessage(
    resource: BlipResourceType,
    propertyName: String,
    propertyValue: String
  ): String =
    "No ${resource.capitalisedSingularName} exists with $propertyName [$propertyValue]"
}