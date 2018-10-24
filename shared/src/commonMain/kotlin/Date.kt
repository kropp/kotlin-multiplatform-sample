fun validate(day: Day, month: Month, year: Year): Boolean {
  return Date(day, month, year).isValid()
}

expect class Date(day: Day, month: Month, year: Year) {
  fun isValid(): Boolean
}

inline class Day(val value: Int)
inline class Month(val value: Int)
inline class Year(val value: Int)