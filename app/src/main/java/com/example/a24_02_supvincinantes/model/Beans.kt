package com.example.a24_02_supvincinantes.model

import java.util.Random

fun main() {

    val randomName = RandomName()
    randomName.add("toto")
    repeat(10) {
        println(randomName.next() + " ")
    }
}

const val LONG_TEXT = """Le Lorem Ipsum est simplement
    du faux texte employé dans la composition
    et la mise en page avant impression.
    Le Lorem Ipsum est le faux texte standard
    de l'imprimerie depuis les années 1500"""
data class PictureBean(val url: String, val text: String, val longText: String)

//jeu de donnée
val pictureList = arrayListOf(PictureBean("https://picsum.photos/200", "ABCD", LONG_TEXT),
    PictureBean("https://picsum.photos/201", "BCDE", LONG_TEXT),
    PictureBean("https://picsum.photos/202", "CDEF", LONG_TEXT),
    PictureBean("https://picsum.photos/203", "EFGH", LONG_TEXT)
)

/* -------------------------------- */
// Exo
/* -------------------------------- */

class RandomName(){
    private val list = arrayListOf("bob", "bobby", "tobby")

    private var oldValue = ""

    fun add(name : String?)=
        if(!name.isNullOrBlank() && name !in list)
            list.add(name)
        else false

    fun next() = list.random()

    fun nextDiffV1() =  list.filter { it != oldValue  }.random().also { oldValue = it  }

    fun next2() = Pair(nextDiff(), nextDiff())

    fun nextDiff(): String {
        var newValue = next()
        while(newValue == oldValue) {
            newValue = next()
        }
        oldValue = newValue
        return oldValue
    }
}


class ThermometerBean(val min: Int, val max: Int, value: Int) {
    var value = value.coerceIn(min, max)
        set(newValue) {
            field = newValue.coerceIn(min, max)
        }

    companion object {
        fun getCelsiusThermometer() = ThermometerBean(-30,50, 0)
        fun getFahrenheitThermometer() = ThermometerBean(20,120, 32)
    }




}

class PrintRandomIntBean(val max: Int) {
    private val random = Random()

    init {
        println("init")
        println(random.nextInt(max))
        println(random.nextInt(max))
        println(random.nextInt(max))
    }

    constructor() : this(100) {
        println("constructor")
        println(random.nextInt(max))
    }

}

class HouseBean(var color: String, width: Int, length: Int) {
    var surface = width * length

    fun print() = println("La maison $color de surface ${surface}m²")
}

data class CarBean(var marque: String = "", var model: String? = null) {

    var color = ""

    fun print() = println("$marque $model $color")
}