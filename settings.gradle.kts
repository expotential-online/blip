rootProject.name = "blip"

include(
  "model",
  "webservice"
)

val jakartaVersion = "2.2.3"
val kotlinVersion = "1.9.0"
// See https://stackoverflow.com/questions/70036953/spring-boot-2-6-0-spring-fox-3-failed-to-start-bean-documentationpluginsboo
// and the whole Jakarta mess
val springVersion = "2.5.15"
val swaggerVersion = "3.0.0"

dependencyResolutionManagement {
  versionCatalogs {
    create("libs") {
      library("h2", "com.h2database:h2:2.2.220")
      library("jakarta-persistence", "jakarta.persistence:jakarta.persistence-api:$jakartaVersion")
      library("jackson", "com.fasterxml.jackson.module:jackson-module-kotlin:2.15.2")
      library("jaxb", "javax.xml.bind:jaxb-api:2.3.1")
      library("kotlin-noarg", "org.jetbrains.kotlin:kotlin-noarg:$kotlinVersion")
      library("kotlin-reflect", "org.jetbrains.kotlin:kotlin-reflect:$kotlinVersion")
      library("kotlin-stdlib", "org.jetbrains.kotlin:kotlin-stdlib:$kotlinVersion")
      library("starter-jpa", "org.springframework.boot:spring-boot-starter-data-jpa:$springVersion")
      library("starter-swagger", "io.springfox:springfox-boot-starter:$swaggerVersion")
      library("starter-validation", "org.springframework.boot:spring-boot-starter-validation:$springVersion")
      library("starter-web", "org.springframework.boot:spring-boot-starter-web:$springVersion")
    }
  }
}