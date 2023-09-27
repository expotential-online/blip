package blip.webservice.security

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority

enum class Role(private val authority: String) : GrantedAuthority {
  ANYBODY("anybody"),
  ADMINISTRATOR("administrator")
  ;

  private val grantedAuthority: SimpleGrantedAuthority = SimpleGrantedAuthority(authority)

  override fun getAuthority(): String = authority

  fun grantedAuthority(): SimpleGrantedAuthority = grantedAuthority
}