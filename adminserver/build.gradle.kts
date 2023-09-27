plugins {
  id("blip-kotlin-conventions")
  kotlin("plugin.jpa") version "1.9.0"
  kotlin("plugin.spring") version "1.9.0"
}

dependencies {
  implementation(project(":model"))
  implementation(libs.kotlin.reflect)
  implementation(libs.kotlin.stdlib)
  implementation(libs.starter.admin.server)
  implementation(libs.starter.webflux)
}

sonarqube {
  properties {
    property("sonar.projectKey", "expotential-online_blip")
    property("sonar.organization", "expotential-online")
    property("sonar.host.url", "https://sonarcloud.io")
  }
}