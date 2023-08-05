plugins {
  kotlin("jvm")
  id("org.sonarqube")
  jacoco
}

group = "blip"

repositories {
  mavenCentral()
}

dependencies {
  testImplementation("org.junit.jupiter:junit-jupiter:5.10.0")
}

kotlin {
  jvmToolchain(20)
}

tasks.jacocoTestReport {
  reports.xml.required.set(true)
}

tasks.withType<Test> {
  useJUnitPlatform()
}

