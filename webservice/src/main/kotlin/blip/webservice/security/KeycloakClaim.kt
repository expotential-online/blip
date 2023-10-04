package blip.webservice.security

enum class KeycloakClaim(val rawName: String) {
  ClientName("azp"),
  RealmAccess("realm_access")
}