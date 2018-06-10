package demo.multi

import kotlinx.serialization.*
import kotlinx.serialization.internal.LongSerializer
import kotlinx.serialization.internal.PrimitiveDesc
import moment.moment
import kotlin.js.Date

@Serializable
actual class DateTime actual constructor(actual val time: Long) {
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
  actual operator fun compareTo(other: DateTime) = (time.asDynamic() - other.time.asDynamic()) as Int

  fun short(): String {
    return moment(time).format("YYYY-MM-DD")
  }
}