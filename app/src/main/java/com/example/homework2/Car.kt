package com.example.homework2


data class Car(val make: String, val model: String, val year: Int, val color: Color, val price: Double, val tyres: Tyres)

enum class Color {
    RED, BLUE, GREEN, YELLOW, PURPLE
}
enum class Tyres {
    WINTER, SUMMER, SEASON, SLICKS
}


