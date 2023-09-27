plugins {
  id("blip-kotlin-conventions")
  kotlin("plugin.spring") version "1.9.0"
}

dependencies {
  implementation(project(":model"))
  implementation(libs.h2)
  implementation(libs.jackson)
  implementation(libs.jaxb)
  implementation(libs.jwt)
  implementation(libs.keycloak.authz.client)
  implementation(libs.kotlin.reflect)
  implementation(libs.kotlin.stdlib)
  implementation(libs.starter.admin.client)
  implementation(libs.starter.oauth2.client)
  implementation(libs.starter.oauth2.resourceserver)
  implementation(libs.starter.security)
  implementation(libs.starter.springdoc)
  implementation(libs.starter.validation)
  implementation(libs.starter.web)
  implementation(libs.starter.webflux)
}

sonarqube {
  properties {
    property("sonar.projectKey", "expotential-online_blip")
    property("sonar.organization", "expotential-online")
    property("sonar.host.url", "https://sonarcloud.io")
  }
}