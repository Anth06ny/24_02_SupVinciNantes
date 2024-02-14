package com.example.a24_02_supvincinantes.exo

fun main() {
    exo2()
}

data class PersonBean(var name: String, var note: Int)

fun exo4() {
    val list = arrayListOf(
        PersonBean("toto", 16),
        PersonBean("Tata", 20),
        PersonBean("Toto", 8),
        PersonBean("Charles", 14)
    )

    println("Afficher la sous liste de personne ayant 10 et +")
    //println(list.filter { it.note >=10 })
    //Pour un affichage de notre choix
    println(list.filter { it.note >= 10 }.joinToString("\n") { "-${it.name} : ${it.note}" })

    //TODO
    println("\n\nAfficher combien il y a de Toto dans la classe ?")
    var lambdaIsToto = { u: PersonBean -> u.name.equals("toto", true) }
    list.count(lambdaIsToto)
    list.count { it.name.equals("toto", true) }

    println("\n\nAfficher combien de Toto ayant la moyenne (10 et +)")
    list.count { lambdaIsToto(it) && it.note >= 10 }

    println("\n\nAfficher combien de Toto ont plus que la moyenne de la classe")
    val average = list.map { it.note }.average()
    list.count { lambdaIsToto(it) && it.note >= average }

    println("\n\nAfficher la list triée par nom sans doublon")
    list.sortedBy { it.name.lowercase() }.distinctBy { it.name }

    println("\n\nAjouter un point a ceux n’ayant pas la moyenne (<10)")
    list.filter { it.note < 10 }.forEach {
        it.note++
    }

    println("\n\nAjouter un point à tous les Toto")
    list.filter(lambdaIsToto).forEach {
        it.note++
    }

    println("\n\nRetirer de la liste ceux ayant la note la plus petite. (Il faut une ArrayList)")
    val minusNote: Int = list.minOf { it.note }
    list.removeIf { it.note == minusNote  }

    println("\n\nAfficher les noms de ceux ayant la moyenne(10et+) par ordre alphabétique")

    val res = list.filter{it.note >= 10}.sortedBy { it.name }.joinToString { it.name }
    println(res)

    println("\n\nAfficher par notes croissantes les élèves ayant eu cette note comme sur l'exemple")

    list.groupBy { it.note }.entries.sortedBy { it.key }.joinToString("\n") {
        "${it.key} : ${it.value.joinToString { it.name }}"
    }
}

data class UserBean(var name: String, var old: Int)

fun exo2() {
    val compareUsersByName: (UserBean, UserBean) -> UserBean = { u1, u2 ->
        if (u1.name.lowercase() <= u2.name.lowercase()) u1 else u2
    }

    val compareUsersByOld: (UserBean, UserBean) -> UserBean = { u1, u2 ->
        if (u1.old <= u2.old) u1 else u2
    }

    val u1 = UserBean("Bob", 19)
    val u2 = UserBean("Toto", 45)
    val u3 = UserBean("Charles", 26)
    println(compareUsers(u1, u2, u3, compareUsersByName)) // UserBean(name=Bob old=19)

    println(compareUsers(u1, u2, u3, compareUsersByOld))

    val near30 = compareUsers(u1, u2, u3) { u1, u2 ->
        if (Math.abs(u1.old - 30) < Math.abs(u2.old - 30)) u1 else u2
    }

    println("max=$near30")

}

fun compareUsers(
    u1: UserBean, u2: UserBean, u3: UserBean,
    comparator: (UserBean, UserBean) -> UserBean
): UserBean {
    val maxu1u2 = comparator(u1, u2)
    return comparator(maxu1u2, u3)
}


fun exo1() {
//    lower : Prend un texte et l’affiche en minuscule (.lowercase())
    val lower = { it: String ->
        println(it.lowercase())
    }
    lower("Coucou")


//    heure : prenant un nombre de minutes et retournant le nombre d’heures équivalentes
    val hour = { nbMinute: Int -> nbMinute / 60 }
    println("hour=$hour")


//    max : prenant 2 entiers et retournant le plus grand (Math.max())
    val max: (Int, Int) -> Int = { a: Int, b: Int ->
        Math.max(a, b)
    }
    var res = max(3, 5)
    println("res=$res")

//    reverse : retourne le texte à l’envers toto -> otot (.reversed())
    val reverse: (String) -> String = { it.reversed() }
    println("reverse=$reverse")

    var minToMinHour: ((Int?) -> Pair<Int, Int>?)? = {
        if (it != null) Pair(it / 60, it % 60) else null
    }

    minToMinHour = null

    val minHour = minToMinHour?.invoke(5465)
    println("${minHour?.first ?: "-"}h${minHour?.second ?: "-"}")
}