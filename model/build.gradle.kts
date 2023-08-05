plugins {
  id("blip-kotlin-conventions")
  kotlin("plugin.jpa") version "1.9.0"
  kotlin("plugin.spring") version "1.9.0"
}

dependencies {
  implementation("jakarta.persistence:jakarta.persistence-api:3.1.0")
  implementation("org.jetbrains.kotlin:kotlin-noarg:1.9.0")
}

sonarqube {
  properties {
    property("sonar.projectKey", "expotential-online_blip")
    property("sonar.organization", "expotential-online")
    property("sonar.host.url", "https://sonarcloud.io")
  }
}