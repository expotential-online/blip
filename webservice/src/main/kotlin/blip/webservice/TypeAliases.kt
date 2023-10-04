package blip.webservice

import org.springframework.data.jpa.repository.JpaRepository

typealias Repo<M, I> = JpaRepository<M, I>
typealias Urgency = Double