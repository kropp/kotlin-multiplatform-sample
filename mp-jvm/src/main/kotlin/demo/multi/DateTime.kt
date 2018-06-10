package demo.multi

import kotlinx.serialization.Serializable
import java.time.Instant
import java.time.format.DateTimeFormatter

@Serializable
actual class DateTime actual constructor(actual val time: Long) {
  actual companion object {
    actual val now get() = DateTime(Instant.now().toEpochMilli())
  }
  actual fun formatted() = DateTimeFormatter.ISO_LOCAL_DATE.format(Instant.ofEpochMilli(time))
  actual operator fun compareTo(other: DateTime) = (time - other.time).toInt()}