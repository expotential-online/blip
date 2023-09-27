package blip.testclient

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BlipTestClient

fun main(args: Array<String>) {
  runApplication<BlipTestClient>(*args)
}