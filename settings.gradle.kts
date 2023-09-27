rootProject.name = "blip"

include(
  "adminserver",
  "model",
  "testclient",
  "webservice"
)

val adminServerVersion = "2.5.6"
val jakartaVersion = "3.1.0"
val jwtVerion = "0.11.5"
val keycloakVersion = "22.0.3"
val kotlinVersion = "1.9.0"
// See https://stackoverflow.com/questions/70036953/spring-boot-2-6-0-spring-fox-3-failed-to-start-bean-documentationpluginsboo
// and the whole Jakarta mess
val springVersion = "3.1.4"
val springdocVersion = "2.2.0"
val swaggerVersion = "3.0.0"

dependencyResolutionManagement {
  versionCatalogs {
    create("libs") {
      library("h2", "com.h2database:h2:2.2.220")
      library("jakarta-persistence", "jakarta.persistence:jakarta.persistence-api:$jakartaVersion")
      library("jackson", "com.fasterxml.jackson.module:jackson-module-kotlin:2.15.2")
      library("jaxb", "javax.xml.bind:jaxb-api:2.3.1")
      library("jwt", "io.jsonwebtoken:jjwt-api:$jwtVerion")
      library("keycloak-authz-client", "org.keycloak:keycloak-authz-client:$keycloakVersion")
      library("kotlin-noarg", "org.jetbrains.kotlin:kotlin-noarg:$kotlinVersion")
      library("kotlin-reflect", "org.jetbrains.kotlin:kotlin-reflect:$kotlinVersion")
      library("kotlin-stdlib", "org.jetbrains.kotlin:kotlin-stdlib:$kotlinVersion")
      library("starter-admin-client", "de.codecentric:spring-boot-admin-starter-client:$adminServerVersion")
      library("starter-admin-server", "de.codecentric:spring-boot-admin-starter-server:$adminServerVersion")
      library("starter-jpa", "org.springframework.boot:spring-boot-starter-data-jpa:$springVersion")
      library("starter-oauth2-client", "org.springframework.boot:spring-boot-starter-oauth2-client:$springVersion")
      library(
        "starter-oauth2-resourceserver",
        "org.springframework.boot:spring-boot-starter-oauth2-resource-server:$springVersion"
      )
      library("starter-security", "org.springframework.boot:spring-boot-starter-security:$springVersion")
      library("starter-springdoc", "org.springdoc:springdoc-openapi-starter-webmvc-ui:$springdocVersion")
      library("starter-swagger", "io.springfox:springfox-boot-starter:$swaggerVersion")
      library("starter-validation", "org.springframework.boot:spring-boot-starter-validation:$springVersion")
      library("starter-web", "org.springframework.boot:spring-boot-starter-web:$springVersion")
      library("starter-webflux", "org.springframework.boot:spring-boot-starter-webflux:$springVersion")
    }
  }
}