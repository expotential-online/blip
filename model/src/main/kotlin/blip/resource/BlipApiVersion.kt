package blip.resource

import blip.core.UrlPart

enum class BlipApiVersion(val urlPart: UrlPart) {
  V1_0(UrlParts.V1_0);

  object UrlParts {
    const val V1_0: UrlPart = "v1.0"
  }
}