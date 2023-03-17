package com.example.homework2


data class Car(val make: String, val model: String, val year: Int, val color: Color, val price: Double, val tyres: Tyres)

enum class Color(val hexValue: String) {
    RED("#FF0000"),
    BLUE("#0000FF"),
    GREEN("#00FF00"),
    YELLOW("#FFFF00"),
    PURPLE("#800080")
}
fun Color.getHex() : Int{
    return this.hexValue.toInt()
}
enum class Tyres {
    WINTER, SUMMER, SEASON, SLICKS
}


