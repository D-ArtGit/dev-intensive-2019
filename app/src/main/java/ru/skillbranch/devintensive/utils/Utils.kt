package ru.skillbranch.devintensive.utils

object Utils {
    fun parseFullName(fullName:String?) :Pair<String?, String?>{
        var fN:String?
        when(fullName) {
            "", " " -> fN = null
            else -> fN = fullName
        }
        val parts : List<String>? = fN?.split(" ")

        val firstName = parts?.getOrNull(0)
        val lastName = parts?.getOrNull(1)
//        return Pair(firstName, lastName)
        return firstName to lastName
    }

    fun transliteration(payload: String, divider: String = " "): String {
        var output:String = payload.replace(" ", divider, false)
        output = output.replace("а", "a", false)
        output = output.replace("б", "b", false)
        output = output.replace("в", "v", false)
        output = output.replace("г", "g", false)
        output = output.replace("д", "d", false)
        output = output.replace("е", "e", false)
        output = output.replace("ё", "e", false)
        output = output.replace("ж", "zh", false)
        output = output.replace("з", "z", false)
        output = output.replace("и", "i", false)
        output = output.replace("й", "i", false)
        output = output.replace("к", "k", false)
        output = output.replace("л", "l", false)
        output = output.replace("м", "m", false)
        output = output.replace("н", "n", false)
        output = output.replace("о", "o", false)
        output = output.replace("п", "p", false)
        output = output.replace("р", "r", false)
        output = output.replace("с", "s", false)
        output = output.replace("т", "t", false)
        output = output.replace("у", "u", false)
        output = output.replace("ф", "f", false)
        output = output.replace("х", "h", false)
        output = output.replace("ц", "c", false)
        output = output.replace("ч", "ch", false)
        output = output.replace("ш", "sh", false)
        output = output.replace("щ", "sh'", false)
        output = output.replace("ъ", "", false)
        output = output.replace("ы", "i", false)
        output = output.replace("ь", "", false)
        output = output.replace("э", "e", false)
        output = output.replace("ю", "yu", false)
        output = output.replace("я", "ya", false)
        output = output.replace("А", "A", false)
        output = output.replace("Б", "B", false)
        output = output.replace("В", "V", false)
        output = output.replace("Г", "G", false)
        output = output.replace("Д", "D", false)
        output = output.replace("Е", "E", false)
        output = output.replace("Ё", "E", false)
        output = output.replace("Ж", "Zh", false)
        output = output.replace("З", "Z", false)
        output = output.replace("И", "I", false)
        output = output.replace("Й", "I", false)
        output = output.replace("К", "K", false)
        output = output.replace("Л", "L", false)
        output = output.replace("М", "M", false)
        output = output.replace("Н", "N", false)
        output = output.replace("О", "O", false)
        output = output.replace("П", "P", false)
        output = output.replace("Р", "R", false)
        output = output.replace("С", "S", false)
        output = output.replace("Т", "T", false)
        output = output.replace("У", "U", false)
        output = output.replace("Ф", "F", false)
        output = output.replace("Х", "H", false)
        output = output.replace("Ц", "C", false)
        output = output.replace("Ч", "Ch", false)
        output = output.replace("Ш", "Sh", false)
        output = output.replace("Щ", "Sh'", false)
        output = output.replace("Ъ", "", false)
        output = output.replace("Ы", "I", false)
        output = output.replace("Ь", "", false)
        output = output.replace("Э", "E", false)
        output = output.replace("Ю", "Yu", false)
        output = output.replace("Я", "Ya", false)

        return output
    }

    fun toInitials(firstName: String?, lastName: String?): String? {
        val initials:String?
        when {
            firstName.isNullOrEmpty() -> initials = null
            firstName.isNotBlank() && lastName.isNullOrEmpty() -> initials = firstName?.capitalize()?.get(0).toString()
            firstName.isNotBlank() && lastName!!.isNotBlank() -> initials = firstName?.capitalize()?.get(0).toString() + lastName?.capitalize()?.get(0).toString()
            else -> initials = null
        }
        return initials
    }
}