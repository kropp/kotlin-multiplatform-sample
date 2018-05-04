import demo.multi.DateTime
import demo.multi.Todo
import demo.multi.TodoList
import io.ktor.application.call
import io.ktor.http.ContentType
import io.ktor.http.HttpStatusCode
import io.ktor.request.receiveText
import io.ktor.response.respond
import io.ktor.response.respondText
import io.ktor.routing.*
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import kotlinx.serialization.json.JSON
import java.util.*

fun main(args: Array<String>) {
  val todos = mutableMapOf("7c4f6cf1-c955-47ef-9fea-6f1929697ec8" to Todo("7c4f6cf1-c955-47ef-9fea-6f1929697ec8", "First Todo", DateTime.now))

  val server = embeddedServer(Netty, 8080) {
    routing {
      get("/api/todo") {
        call.respondText(JSON.stringify(TodoList(todos.values.toTypedArray())), ContentType.Application.Json)
      }
      get("/api/todo/{id}") {
        val id = call.parameters["id"]!!
        if (id in todos) {
          call.respondText(JSON.stringify(todos[id]!!))
        } else {
          call.respond(HttpStatusCode.NotFound)
        }
      }
      post("/api/todo") {
        val id = UUID.randomUUID().toString()
        val text = call.receiveText()
        todos[id] = JSON.parse<Todo>(text).copy(id = id)
        call.respondText(JSON.stringify(todos[id]!!))
      }
      put("/api/todo/{id}") {
        val id = call.parameters["id"]!!
        if (id in todos) {
          todos[id] = JSON.parse<Todo>(call.receiveText()).copy(id = id)
          call.respondText(JSON.stringify(todos[id]!!))
        } else {
          call.respond(HttpStatusCode.NotFound)
        }
      }
      delete("/api/todo/{id}") {
        val id = call.parameters["id"]!!
        if (id in todos) {
          todos.remove(id)
          call.respond(HttpStatusCode.OK)
        } else {
          call.respond(HttpStatusCode.NotFound)
        }
      }
    }
  }
  server.start(wait = true)
}