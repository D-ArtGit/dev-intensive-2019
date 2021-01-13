package ru.skillbranch.devintensive.extensions

fun String.truncate(num: Int = 16):String{
    val str = this.trim()
    val len = str.length
    return if (len < num) str else
        str.substring(0, num).trim() + "..."
}

fun String.stripHtml():String{
    val str = this.trim()
    val patSpace = "\\s+".toRegex()
    val patTag = "<[^>]*>".toRegex()
    val patOut = "[&'\"]".toRegex()
    return str.replace(patTag, "").replace(patOut, "").replace(patSpace, " ")
}