import kotlin.test.*

class DateTest {
  @Test fun validateBirthday() {
    assertFalse(validate(Day(3), Month(31), Year(1986)))
    assertTrue(validate(Month(31), Day(3), Year(1986)))
  }
}