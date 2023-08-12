plugins {
  id("blip-kotlin-conventions")
  kotlin("plugin.jpa") version "1.9.0"
  kotlin("plugin.spring") version "1.9.0"
}

dependencies {
  implementation(project(":model"))
  implementation(libs.h2)
  implementation(libs.jackson)
  implementation(libs.jaxb)
  implementation(libs.kotlin.reflect)
  implementation(libs.kotlin.stdlib)
  implementation(libs.starter.jpa)
  implementation(libs.starter.swagger)
  implementation(libs.starter.validation)
  implementation(libs.starter.web)
}

sonarqube {
  properties {
    property("sonar.projectKey", "expotential-online_blip")
    property("sonar.organization", "expotential-online")
    property("sonar.host.url", "https://sonarcloud.io")
  }
}