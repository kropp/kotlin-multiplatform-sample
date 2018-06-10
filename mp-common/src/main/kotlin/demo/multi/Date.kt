package demo.multi

import kotlinx.serialization.Serializable

@Serializable
expect class DateTime(time: Long) {
  val time: Long
  companion object {
    val now: DateTime
  }
  fun formatted(): String
  operator fun compareTo(other: DateTime): Int
}