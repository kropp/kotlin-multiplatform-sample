import react.RBuilder
import react.RComponent
import react.dom.div
import react.dom.h1

class ApplicationComponent : RComponent<NoProps, NoState>() {
  override fun RBuilder.render() {
    div {
      h1 {
        +"ToDo"
      }
      todoList()
    }
  }
}

fun RBuilder.app() = child(ApplicationComponent::class) {}