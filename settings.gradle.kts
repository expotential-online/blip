rootProject.name = "blip"

include(
  "model",
  "webservice"
)

val jakartaVersion = "3.1.0"
val kotlinVersion = "1.9.0"
val springVersion = "3.1.2"

dependencyResolutionManagement {
  versionCatalogs {
    create("libs") {
      library("jakarta-persistence", "jakarta.persistence:jakarta.persistence-api:$jakartaVersion")
      library("kotlin-noarg", "org.jetbrains.kotlin:kotlin-noarg:$kotlinVersion")
      library("starter-web", "org.springframework.boot:spring-boot-starter-web:$springVersion")
    }
  }
}