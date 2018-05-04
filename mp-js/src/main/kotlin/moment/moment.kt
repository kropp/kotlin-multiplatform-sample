package moment

external interface Moment {
  fun format(format: String? = definedExternally): String
}

@JsModule("moment")
external fun moment(time: Number): Moment = definedExternally
