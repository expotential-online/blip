package blip.webservice.config

import blip.webservice.security.KeycloakClaim.RealmAccess
import blip.webservice.security.KeycloakLogoutHandler
import blip.webservice.security.claimFromEnum
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.session.SessionRegistryImpl
import org.springframework.security.oauth2.jwt.Jwt
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.authentication.session.RegisterSessionAuthenticationStrategy
import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(securedEnabled = true)
class SecurityConfig(
  @Autowired private val logoutHandler: KeycloakLogoutHandler
) {

  @Bean
  fun sessionAuthenticationStrategy(): SessionAuthenticationStrategy =
    RegisterSessionAuthenticationStrategy(SessionRegistryImpl())


  @Bean
  fun filterChain(http: HttpSecurity): SecurityFilterChain {
//    http.authorizeRequests()
//      .antMatchers("/*")
//      .hasRole("user")
//      .anyRequest()
//      .permitAll();
//    http.oauth2Login()
//      .and()
//      .logout()
//      .addLogoutHandler(logoutHandler)
//      .logoutSuccessUrl("/")
    http.oauth2ResourceServer {
      it.jwt { it.jwtAuthenticationConverter(authenticationConverter()) }
    }
    return http.build()
  }

  private fun authenticationConverter(): JwtAuthenticationConverter {
    val converter = JwtAuthenticationConverter()
    converter.setJwtGrantedAuthoritiesConverter(this::authorities)
    return converter
  }

  private fun authorities(jwt: Jwt): Collection<GrantedAuthority> {
    return jwt.claimFromEnum<Map<String, Collection<String>>>(RealmAccess)
      ?.get("roles")
      ?.map { SimpleGrantedAuthority("ROLE_$it") }
      ?.toList()
      ?: listOf()
  }
}