package moment

external interface Moment {
  fun format(format: String? = definedExternally): String
  fun valueOf(): Long
}

@JsModule("moment")
external fun moment(time: Number): Moment = definedExternally

@JsModule("moment")
external fun moment(str: String): Moment = definedExternally
