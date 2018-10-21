import java.util.*


actual class Date actual constructor(private val day: Int, private val month: Int, private val year: Int) {
  actual fun isValid() = true
      /*try {
        val calendar = Calendar.getInstance()
        calendar.isLenient = false
        calendar.set(year, month, day)
        true
      } catch (e: Exception) {
        false
      }*/
}