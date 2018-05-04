import react.dom.render
import kotlin.browser.document

fun main(args: Array<String>) {
  console.log("Starting application")

  document.addEventListener("DOMContentLoaded", {
    render(document.getElementById("content")) {
      app()
    }
  })
}