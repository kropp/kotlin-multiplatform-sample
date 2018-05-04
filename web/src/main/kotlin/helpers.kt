import org.w3c.fetch.RequestInit
import react.RProps
import react.RState

interface NoProps : RProps
interface NoState : RState

fun POST(payload: Any): RequestInit = object : RequestInit {
  override var method: String? = "POST"
  override var body = JSON.stringify(payload)
}

val DELETE: RequestInit = object : RequestInit {
  override var method: String? = "DELETE"
}
