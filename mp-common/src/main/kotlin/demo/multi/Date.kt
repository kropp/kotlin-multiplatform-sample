package demo.multi

import kotlinx.serialization.Serializable

@Serializable
expect class DateTime(time: Long) {
  companion object {
    val now: DateTime
  }
  fun formatted(): String
}