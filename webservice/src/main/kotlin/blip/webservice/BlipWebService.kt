package blip.webservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication
@EnableJpaRepositories
@EntityScan("blip.model")
class BlipWebService

fun main(args: Array<String>) {
  runApplication<BlipWebService>(*args)
}