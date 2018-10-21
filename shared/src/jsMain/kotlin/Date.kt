import moment.*

actual class Date actual constructor(private val day: Int, private val month: Int, private val year: Int) {
  actual fun isValid() = moment(year, month, day).isValid()
}