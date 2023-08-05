plugins {
  id("blip-kotlin-conventions")
}

sonarqube {
  properties {
    property("sonar.projectKey", "expotential-online_blip")
    property("sonar.organization", "expotential-online")
    property("sonar.host.url", "https://sonarcloud.io")
  }
}