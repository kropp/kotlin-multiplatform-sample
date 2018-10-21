import kotlin.test.*

class DateTest {
  @Test fun validateBirthday() {
    assertFalse(validate(3, 31, 1986))
    assertTrue(validate(31, 3, 1986))
  }
}