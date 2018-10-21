fun validate(day: Int, month: Int, year: Int): Boolean {
  return Date(year, month, day).isValid()
}

expect class Date(day: Int, month: Int, year: Int) {
  fun isValid(): Boolean
}
