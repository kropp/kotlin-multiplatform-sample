import demo.multi.DateTime
import demo.multi.Todo
import demo.multi.TodoList
import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.await
import kotlinx.html.*
import kotlinx.html.js.onChangeFunction
import kotlinx.html.js.onClickFunction
import kotlinx.serialization.json.JSON
import react.*
import react.dom.*
import kotlin.browser.window

class TodoListComponent : RComponent<NoProps, TodoListComponent.State>() {
  init {
    state.todos = TodoList(emptyArray())
    state.text = ""
    state.dueDate = DateTime.now
    refresh()
  }

  override fun RBuilder.render() {
    state.todos.tasks.forEach {
      todo(it, { remove ->
        setState { todos = TodoList(state.todos.tasks.filterNot { it.id ==  remove.id }.toTypedArray()) }
      })
    }
    div {
      input {
        attrs.onChangeFunction = { e ->
          val value = e.target.asDynamic().value
          setState { text = value }
        }
      }
      input {
        attrs.type = InputType.date
        attrs.defaultValue = state.dueDate.short()
        attrs.onChangeFunction = { e ->
          val value = e.target.asDynamic().value
          setState { dueDate = DateTime.parse(value) }
        }
      }
      button {
        +"Add"
        attrs.onClickFunction = {
          async {
            val response = window.fetch("/api/todo", POST(Todo(text = state.text, dateTime = state.dueDate))).await().text().await()
            val newItem = JSON.parse<Todo>(response)
            setState { todos = TodoList(state.todos.tasks + newItem) }
          }
        }
      }
    }
  }

  private fun refresh() {
    async {
      val value = JSON.parse<TodoList>(window.fetch("/api/todo").await().text().await())
      setState { todos = value }
    }
  }

  interface State : RState {
    var todos: TodoList
    var text: String
    var dueDate: DateTime
  }
}

class TodoItemComponent : RComponent<TodoItemComponent.Props, NoState>() {
  override fun RBuilder.render() {
    p {
      attrs.key = props.todo.id!!
      +props.todo.text
      small {
        +" due on "
        i {
          +props.todo.dateTime.formatted()
        }
      }
      button(classes = "delete") {
        +"×"
        attrs.onClickFunction = {
          async {
            window.fetch("/api/todo/${props.todo.id}", DELETE)
            props.remove(props.todo)
          }
        }
      }
    }
  }

  interface Props : RProps {
    var todo: Todo
    var remove: (Todo) -> Unit
  }
}

fun RBuilder.todoList() = child(TodoListComponent::class) {}

fun RBuilder.todo(todo: Todo, remove: (Todo) -> Unit) = child(TodoItemComponent::class) {
  attrs.todo = todo
  attrs.remove = remove
}