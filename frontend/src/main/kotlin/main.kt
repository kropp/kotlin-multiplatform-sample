import react.dom.render
import kotlin.browser.document

fun main() {
  console.log("Starting application")

  document.addEventListener("DOMContentLoaded", {
    render(document.getElementById("content")) {
      app()
    }
  })
}