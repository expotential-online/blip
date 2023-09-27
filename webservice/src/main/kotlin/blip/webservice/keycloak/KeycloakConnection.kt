package blip.webservice.keycloak

class KeycloakConnection(serverUrl: String, realm: String) {

  private companion object {
    private const val REALMS_URL_PART = "realms"
    private const val PROTOCOL_URL_PART = "/protocol/openid-connect"
    private const val AUTH_URL_SUFFIX = "auth"
  }

  val authorisationUrl = "$serverUrl/$REALMS_URL_PART/$realm/$PROTOCOL_URL_PART/$AUTH_URL_SUFFIX"

}