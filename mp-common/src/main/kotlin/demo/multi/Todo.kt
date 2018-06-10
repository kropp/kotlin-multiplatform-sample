package demo.multi

import kotlinx.serialization.Optional
import kotlinx.serialization.Serializable

@Serializable
data class Todo(
    @Optional val id: String? = null,
    val text: String,
    val dueDate: DateTime
)

@Serializable
class TodoList(val tasks: Array<Todo>)