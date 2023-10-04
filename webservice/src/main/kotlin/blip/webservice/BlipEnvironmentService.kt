package blip.webservice

import blip.core.CompleteUrl
import blip.core.UrlPart
import blip.resource.BlipApi
import blip.resource.BlipApiVersion
import blip.resource.BlipResourceType
import org.springframework.stereotype.Service
import org.springframework.web.servlet.support.ServletUriComponentsBuilder

@Service
class BlipEnvironmentService {

  fun resourcePostUrl(apiVersion: BlipApiVersion, resourceType: BlipResourceType): CompleteUrl =
    BlipApi.resourcePostUrl(urlRoot(), apiVersion, resourceType)

  fun <I> resourceGetUrl(apiVersion: BlipApiVersion, resourceType: BlipResourceType, id: I): CompleteUrl =
    BlipApi.resourceGetUrl(urlRoot(), apiVersion, resourceType, id)

  private fun urlRoot(): UrlPart = ServletUriComponentsBuilder.fromCurrentContextPath().toUriString()
}