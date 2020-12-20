package ru.skillbranch.devintensive.extensions

fun String.truncate(num: Int = 16):String{
    val str = this
    val outstr:String
    val len = str.length - 1
    when {
        len < num -> outstr = str
        str.get(num-1).isWhitespace() -> outstr = str.removeRange((num-1)..len)
        else -> outstr = str.removeRange((num)..len)
    }
    return outstr
}