package com.example.countrysearchapp

fun stringCutter(str: String, limit: Int): String {
    var firstPart = ""
    var secondPart = ""
    val strList = str.split(" ")
    strList.forEach {
        if (firstPart.length + it.length + 1 <= limit) firstPart += "$it "
        else {
            secondPart = str.substring(firstPart.length)
        }
    }
    return if (secondPart != "") firstPart + "\n" + secondPart else firstPart
}

