import java.util.*


actual class Date actual constructor(private val day: Int, private val month: Int, private val year: Int) {
  actual fun isValid() =
      try {
        val calendar = Calendar.getInstance()
        calendar.isLenient = false
        calendar.set(year, month - 1, day)
        calendar.time
        true
      } catch (e: Exception) {
        false
      }
}