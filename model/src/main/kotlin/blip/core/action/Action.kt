package blip.core.action

import blip.core.action.ActionType.Create
import blip.core.action.ActionType.Delete
import blip.core.action.ActionType.Update

data class Action<T>(
  val type: ActionType,
  val value: T
) {
  companion object {
    fun <T> creating(value: T): Action<T> = Action(Create, value)
    fun <T> deleting(value: T): Action<T> = Action(Delete, value)
    fun <T> updating(value: T): Action<T> = Action(Update, value)
  }
}
