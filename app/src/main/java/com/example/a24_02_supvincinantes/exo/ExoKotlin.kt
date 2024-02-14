package com.example.a24_02_supvincinantes.exo

fun main() {
    println("Hello World")

    println(scanNumber("Donnez un nombre : "))

}

fun scanNumber(question:String) =
    scanText(question).toIntOrNull() ?: 0

fun scanText(question:String): String {
    print(question)
    return readlnOrNull() ?: "-"
}

fun boulangerie(nbC : Int = 0, nbB : Int = 0, nbSand : Int = 0)=
    nbC * PRICE_CROI + nbB * PRICE_BAG + nbSand * PRICE_SAND


fun myPrint(text:String) = println("#$text#")
fun pair(c:Int) = c%2 == 0

fun min(a: Int, b: Int, c: Int) =
    if (a < b && a < c) a
    else if (b < a && b < c) b
    else c





