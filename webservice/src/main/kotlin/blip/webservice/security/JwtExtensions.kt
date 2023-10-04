package blip.webservice.security

import org.springframework.security.oauth2.jwt.Jwt

fun <T> Jwt.claimFromEnum(keycloakClaim: KeycloakClaim): T? = this.getClaim<T>(keycloakClaim.rawName)