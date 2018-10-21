package moment

external interface Moment {
  fun isValid(): Boolean
}

fun moment(day: Int, month: Int, year: Int) = moment(arrayOf(year, month, day))

//@JsModule("moment")
external fun moment(a: Array<Int>): Moment = definedExternally

//@JsModule("moment")
external fun moment(str: String): Moment = definedExternally