package com.example.a24_02_supvincinantes.model

import com.google.gson.Gson
import okhttp3.OkHttpClient
import okhttp3.Request

//Utilisation
fun main() {
    //Lazy loading + une seule instanciation
//    var html = WeatherAPI.sendGet("https://www.google.fr")
//    println(html)

    val weather = WeatherAPI.loadWeather("Nice")

    println("Il fait ${weather.main.temp}° à ${weather.name} avec un vent de ${weather.wind.speed} m/s")

    val user = WeatherAPI.loadUser()
    println("Il s'appelle ${user.name} pour le contacter :\n" +
            "Phone : ${user.coord?.phone ?: "-"}\n" +
            "Mail : ${user.coord?.mail ?: "-"}")

}

object WeatherAPI {
    val client = OkHttpClient()
    val gson = Gson()

    const val URL_SERVER = "https://api.openweathermap.org/data/2.5"

    fun loadWeather(cityName : String): WeatherBean {
        if(cityName.length < 3) {
            throw Exception("Il faut au moins 3 caractères")
        }

       val json =  sendGet("$URL_SERVER/weather?q=$cityName&appid=b80967f0a6bd10d23e44848547b26550&units=metric&lang=fr")

        return gson.fromJson(json, WeatherBean::class.java)
    }

    fun loadUser(): PersonneBean {

        val json =  sendGet("https://www.amonteiro.fr/api/randomuser")

        return gson.fromJson(json, PersonneBean::class.java)
    }


    //Méthode qui prend en entrée une url, execute la requête
    //Retourne le code HTML/JSON reçu
    fun sendGet(url: String): String {
        println("url : $url")
        //Création de la requête
        val request = Request.Builder().url(url).build()
        //Execution de la requête
        return client.newCall(request).execute().use { //it:Response
            //use permet de fermer la réponse qu'il y ait ou non une exception
            //Analyse du code retour
            if (!it.isSuccessful) {
                throw Exception("Réponse du serveur incorrect :${it.code}")
            }
            //Résultat de la requête
            it.body.string()
        }
    }
}

/* -------------------------------- */
// Beans
/* -------------------------------- */
data class WeatherBean(var main : TempBean,
                       var name :String,
                       var wind : WindBean)
data class TempBean(var temp : Double)
data class WindBean(var speed : Double)


/* -------------------------------- */
// RandomUSer
/* -------------------------------- */
data class PersonneBean(
    val age: Int,
    val coord: Coord?,
    val name: String
)

data class Coord(
    val mail: String?,
    val phone: String?
)