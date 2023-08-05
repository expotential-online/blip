plugins {
  id("blip-kotlin-conventions")
  kotlin("plugin.jpa") version "1.9.0"
  kotlin("plugin.spring") version "1.9.0"
}

dependencies {
  implementation(libs.jakarta.persistence)
  implementation(libs.kotlin.noarg)
}

sonarqube {
  properties {
    property("sonar.projectKey", "expotential-online_blip")
    property("sonar.organization", "expotential-online")
    property("sonar.host.url", "https://sonarcloud.io")
  }
}