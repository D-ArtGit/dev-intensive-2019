package ru.skillbranch.devintensive.extensions

import java.text.SimpleDateFormat
import java.util.*

const val SECOND = 1000L
const val MINUTE = 60 * SECOND
const val HOUR = 60 * MINUTE
const val DAY = 24 * HOUR

fun Date.format(pattern: String="HH:mm:ss dd.MM.yy"):String {
    val dateFormat = SimpleDateFormat(pattern, Locale("ru"))
    return dateFormat.format(this)
}

fun Date.add(value:Int, units: TimeUnits) : Date{
    var time = this.time

    time += when(units){
        TimeUnits.SECOND-> value * SECOND
        TimeUnits.MINUTE-> value * MINUTE
        TimeUnits.HOUR-> value * HOUR
        TimeUnits.DAY-> value * DAY
    }

    this.time = time
    return this
}

fun Date.humanizeDiff(date:Date = Date()): String {
    val timeDiff =  date.time - this.time
    val outDiff:String = when {
        timeDiff in 0L..1000L -> "только что"
        timeDiff in 1001L..45000L -> "несколько секунд назад"
        timeDiff in 45001L..75000L -> "минуту назад"
        timeDiff / MINUTE == 1L || timeDiff / MINUTE == 21L
                || timeDiff / MINUTE == 31L || timeDiff / MINUTE == 41L-> "${timeDiff / MINUTE} минутa назад"
        timeDiff / MINUTE in 2L..4L || timeDiff / MINUTE in 22L..24L
                || timeDiff / MINUTE in 32L..34L || timeDiff / MINUTE in 42L..44L-> "${timeDiff / MINUTE} минуты назад"
        timeDiff / MINUTE in 5L..20L || timeDiff / MINUTE in 25L..30L
                || timeDiff / MINUTE in 35L..40L || timeDiff / MINUTE == 45L-> "${timeDiff / MINUTE} минут назад"
        timeDiff / MINUTE in 45L..75L -> "час назад"
        timeDiff / HOUR == 1L || timeDiff / HOUR == 21L -> "${timeDiff / HOUR} час назад"
        timeDiff / HOUR in 2L..4L || timeDiff / HOUR == 22L -> "${timeDiff / HOUR} часа назад"
        timeDiff / HOUR in 5L..20L -> "${timeDiff / HOUR} часов назад"
        timeDiff / HOUR in 22L..26L -> "день назад"
        timeDiff / DAY == 1L -> "1 день назад"
        timeDiff / DAY in 2L..4L  -> "${timeDiff / DAY} дня назад"
        timeDiff / DAY in 5L..20L || timeDiff / DAY in 105L..120L || timeDiff / DAY in 205L..220L
                || timeDiff / DAY in 305L..320L-> "${timeDiff / DAY} дней назад"
        timeDiff / DAY in 21L..360L -> "${timeDiff / DAY} ${if ((timeDiff / DAY)%10 in 2..4 ) "дня" else
            if ((timeDiff / DAY)%10 == 1L ) "день" else "дней"} назад"
        timeDiff / DAY > 360L -> "более года назад"
        timeDiff * -1 in 0L..1000L -> "только что"
        timeDiff * -1 in 1001L..45000L -> "через несколько секунд"
        timeDiff * -1 in 45001L..75000L -> "через минуту"
        timeDiff / -MINUTE == 1L || timeDiff / -MINUTE == 21L
                || timeDiff / -MINUTE == 31L || timeDiff / -MINUTE == 41L-> "через ${timeDiff / -MINUTE} минуту"
        timeDiff / -MINUTE in 2L..4L || timeDiff / -MINUTE in 22L..24L
                || timeDiff / -MINUTE in 32L..34L || timeDiff / -MINUTE in 42L..44L-> "через ${timeDiff / -MINUTE} минуты"
        timeDiff / -MINUTE in 5L..20L || timeDiff / -MINUTE in 25L..30L
                || timeDiff / -MINUTE in 35L..40L || timeDiff / -MINUTE == 45L-> "через ${timeDiff / -MINUTE} минут"
        timeDiff / -MINUTE in 45L..75L -> "через час"
        timeDiff / -HOUR == 1L || timeDiff / -HOUR == 21L -> "через ${timeDiff / -HOUR} час"
        timeDiff / -HOUR in 2L..4L || timeDiff / -HOUR == 22L -> "через ${timeDiff / -HOUR} часа"
        timeDiff / -HOUR in 5L..20L -> "через ${timeDiff / -HOUR} часов"
        timeDiff / -HOUR in 22L..26L -> "через день"
        timeDiff / -DAY == 1L -> "через 1 день"
        timeDiff / -DAY in 2L..4L  -> "через ${timeDiff / -DAY} дня"
        timeDiff / -DAY in 5L..20L || timeDiff / -DAY in 105L..120L || timeDiff / -DAY in 205L..220L
                || timeDiff / -DAY in 305L..320L-> "через ${timeDiff / -DAY} дней"
        timeDiff / -DAY in 21L..360L -> "через ${timeDiff / -DAY} ${if ((timeDiff / -DAY)%10 in 2..4 ) "дня" else
            if ((timeDiff / -DAY)%10 == 1L ) "день" else "дней"}"
        timeDiff / -DAY > 360L -> "более чем через год"
        else -> "такого не бывает"
    }

    return outDiff
}

enum class TimeUnits(){
    SECOND,
    MINUTE,
    HOUR,
    DAY
}