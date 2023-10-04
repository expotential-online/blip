package blip.webservice.eventbus

import blip.core.event.Event
import reactor.core.publisher.Flux
import reactor.core.publisher.Sinks.Many

typealias EventChannelId = String
typealias EventFlux = Flux<Event>
typealias EventSink = Many<Event>