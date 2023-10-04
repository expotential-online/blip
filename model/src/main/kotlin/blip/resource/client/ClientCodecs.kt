package blip.resource.client

import blip.resource.client.command.RegisterClientCommand
import blip.resource.client.entity.Client
import blip.resource.client.event.ClientRegisteredEvent
import blip.resource.client.rest.ClientGetByIdResponsePayload
import blip.resource.client.rest.ClientPostRequestPayload

fun ClientPostRequestPayload.toRegisterClientCommand(): RegisterClientCommand = with(this) {
  RegisterClientCommand(name, description)
}

fun RegisterClientCommand.toClient(): Client = with(this) {
  Client(name, description)
}

fun Client.toClientRegisteredEvent(): ClientRegisteredEvent = with(this) {
  ClientRegisteredEvent(id!!, name!!, description!!)
}

fun Client.toGetByIdResponsePayload(): ClientGetByIdResponsePayload = with(this) {
  ClientGetByIdResponsePayload(id!!, name!!, description!!)
}