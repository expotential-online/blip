package blip.blip

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BlipApplication

fun main(args: Array<String>) {
  runApplication<BlipApplication>(*args)
}
