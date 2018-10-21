import react.RBuilder
import react.RComponent
import react.dom.*

class ApplicationComponent : RComponent<NoProps, NoState>() {
  override fun RBuilder.render() {
    div {
      h1 {
        +"Registration"
      }
      p {
        +"Enter your data"
      }
      input {}
      input {}
    }
  }
}

fun RBuilder.app() = child(ApplicationComponent::class) {}