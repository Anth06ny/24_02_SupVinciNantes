package com.example.a24_02_supvincinantes.ui

//sealed permet de dire qu'une classe est héritable (ici par SearchScreen et DetailScreen)
//Uniquement par les sous classes qu'elle contient
sealed class Routes(val route: String) {
    //Route 1
    object SearchScreen : Routes("homeScreen")

    //Route 2 avec paramètre
    object DetailScreen : Routes("detailScreen/{data}") {
        //Méthode(s) qui vienne(nt) remplit le ou les paramètres
        fun withPosition(position: Int) = "detailScreen/$position"

        //fun first() = "detailScreen/0"
    }
}