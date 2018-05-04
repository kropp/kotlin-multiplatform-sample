package demo.multi

import kotlinx.serialization.*
import kotlinx.serialization.internal.LongSerializer
import kotlinx.serialization.internal.PrimitiveDesc
import moment.moment
import kotlin.js.Date

@Serializable
actual class DateTime actual constructor(val time: Long) {
  actual companion object {
    actual val now: DateTime
      get() = DateTime(Date().getTime().asDynamic())
  }
  actual fun formatted(): String {
    return moment(time.toDouble()).format("dddd, MMMM Do YYYY, k:mm:ss")
  }
}