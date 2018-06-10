package demo.multi

import kotlinx.serialization.Optional
import kotlinx.serialization.Serializable

@Serializable
data class Todo(
    @Optional val id: String? = null,
    val text: String,
    val dueDate: DateTime
) {
  fun isValid() = if (dueDate < DateTime.now) {
    "Due date must be in future"
  } else {
    null
  }
}

@Serializable
class TodoList(val tasks: Array<Todo>)