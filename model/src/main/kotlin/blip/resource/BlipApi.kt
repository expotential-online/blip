package blip.resource

import blip.core.CompleteUrl
import blip.core.UrlPart

object BlipApi {

  fun resourcePostUrl(urlRoot: UrlPart, apiVersion: BlipApiVersion, resource: BlipResourceType): CompleteUrl =
    "$urlRoot/${apiVersion.urlPart}/${resource.pluralisedUrlPart}"

  fun <I> resourceGetUrl(urlRoot: UrlPart, apiVersion: BlipApiVersion, resource: BlipResourceType, id: I): CompleteUrl =
    "$urlRoot/${apiVersion.urlPart}/${resource.pluralisedUrlPart}/${id.toString()}"
}