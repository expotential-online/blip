package blip.adminserver

import de.codecentric.boot.admin.server.config.EnableAdminServer
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@EnableAdminServer
@SpringBootApplication
class BlipAdminServer

fun main(args: Array<String>) {
  runApplication<BlipAdminServer>(*args)
}