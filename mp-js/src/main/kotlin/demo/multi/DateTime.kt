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
    fun parse(str: String): DateTime {
      return DateTime(moment(str).valueOf())
    }
  }
  actual fun formatted(): String {
    return moment(time.toDouble()).format("dddd, MMMM Do YYYY")
  }
  fun short() = moment(time).format("YYYY-MM-DD")
}