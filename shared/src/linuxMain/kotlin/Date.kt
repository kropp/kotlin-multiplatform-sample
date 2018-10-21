actual class Date actual constructor(private val day: Int, private val month: Int, private val year: Int) {
  actual fun isValid() = month <= 12
}