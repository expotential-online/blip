package blip.resource

import blip.core.CompleteUrl
import blip.core.UrlPart

object BlipApi {

  fun postUrl(urlRoot: UrlPart, apiVersion: BlipApiVersion, resource: BlipResourceType): CompleteUrl =
    "$urlRoot/${apiVersion.urlPart}/${resource.pluralisedUrlPart}"
}