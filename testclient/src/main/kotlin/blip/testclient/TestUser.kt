package blip.testclient

import org.springframework.core.env.Environment

enum class TestUser(private val configName: TestUserConfigName) {
  AdminUser("admin_user"),
  NonAdminUser1("non_admin_user1"),
  NonAdminUser2("non_admin_user2");

  fun username(environment: Environment): TestUserName =
    property(environment, configName, "username")

  fun password(environment: Environment): TestUserPassword =
    property(environment, configName, "password")

  private fun property(environment: Environment, configName: TestUserConfigName, propertySuffix: String): String {
    val propertyName = "blip.test_client.users.$configName.$propertySuffix"
    return environment.getProperty(propertyName) ?: throw RuntimeException("Property [$propertyName] not found")
  }
}