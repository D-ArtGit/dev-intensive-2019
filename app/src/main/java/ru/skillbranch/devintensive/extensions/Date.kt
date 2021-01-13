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
        timeDiff / MINUTE in 1L..45L-> "${TimeUnits.MINUTE.plural((timeDiff / MINUTE).toInt())} назад"
        timeDiff / MINUTE in 45L..75L -> "час назад"
        timeDiff / HOUR in 1L..22L -> "${TimeUnits.HOUR.plural((timeDiff / HOUR).toInt())} назад"
        timeDiff / HOUR in 22L..26L -> "день назад"
        timeDiff / DAY == 1L -> "1 день назад"
        timeDiff / DAY in 2L..360L -> "${TimeUnits.DAY.plural((timeDiff / DAY).toInt())} назад"
        timeDiff / DAY > 360L -> "более года назад"
        timeDiff * -1 in 0L..1000L -> "только что"
        timeDiff * -1 in 1001L..45000L -> "через несколько секунд"
        timeDiff * -1 in 45001L..75000L -> "через минуту"
        timeDiff / -MINUTE in 1L..45L-> "через ${TimeUnits.MINUTE.plural((timeDiff / -MINUTE).toInt())}"
        timeDiff / -MINUTE in 45L..75L -> "через час"
        timeDiff / -HOUR in 1L..20L -> "через ${TimeUnits.HOUR.plural((timeDiff / -HOUR).toInt())}"
        timeDiff / -HOUR in 22L..26L -> "через день"
        timeDiff / -DAY == 1L -> "через 1 день"
        timeDiff / -DAY in 2L..360L -> "через ${TimeUnits.DAY.plural((timeDiff / -DAY).toInt())}"
        timeDiff / -DAY > 360L -> "более чем через год"
        else -> "такого не бывает"
    }

    return outDiff
}

enum class TimeUnits(){
    SECOND,
    MINUTE,
    HOUR,
    DAY;

    fun plural(t: Int):String {
        val outstr = when {
            this == TimeUnits.SECOND && ((t % 100) in 10..20 || (t % 10) in 5..9 || (t % 10) == 0) -> "$t секунд"
            this == TimeUnits.SECOND && (t % 10) == 1 -> "$t секунду"
            this == TimeUnits.SECOND && (t % 10) in 2..4 -> "$t секунды"
            this == TimeUnits.MINUTE && ((t % 100) in 10..20 || (t % 10) in 5..9 || (t % 10) == 0) -> "$t минут"
            this == TimeUnits.MINUTE && (t % 10) == 1 -> "$t минуту"
            this == TimeUnits.MINUTE && (t % 10) in 2..4 -> "$t минуты"
            this == TimeUnits.HOUR && ((t % 100) in 10..20 || (t % 10) in 5..9 || (t % 10) == 0) -> "$t часов"
            this == TimeUnits.HOUR && (t % 10) == 1 -> "$t час"
            this == TimeUnits.HOUR && (t % 10) in 2..4 -> "$t часа"
            this == TimeUnits.DAY && ((t % 100) in 10..20 || (t % 10) in 5..9 || (t % 10) == 0) -> "$t дней"
            this == TimeUnits.DAY && (t % 10) == 1 -> "$t день"
            this == TimeUnits.DAY && (t % 10) in 2..4 -> "$t дня"
            else -> "такого не былвает"
        }
        return outstr
    }
}

