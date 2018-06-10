package demo.multi


class TimeRange(val millis: Int)
val Int.days get() = TimeRange(this * 24 * 60 * 60 * 1000)
operator fun DateTime.plus(r: TimeRange) = DateTime(this.time + r.millis)