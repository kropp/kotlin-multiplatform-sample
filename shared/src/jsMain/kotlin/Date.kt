import moment.*

actual class Date actual constructor(private val day: Day, private val month: Month, private val year: Year) {
  actual fun isValid() = moment(year.value, month.value, day.value).isValid()
}