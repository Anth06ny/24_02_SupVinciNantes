package com.example.a24_02_supvincinantes

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.a24_02_supvincinantes.model.PictureBean
import com.example.a24_02_supvincinantes.model.WeatherAPI
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    val searchText = mutableStateOf("")
    val myList = mutableStateListOf<PictureBean>()
    val runInProgress = mutableStateOf(false)
    val errorMessage = mutableStateOf("")


    val selectedPicture = mutableStateOf<PictureBean?>(null)

    fun uploadSearchText(newText: String) {
        searchText.value = newText
    }

    fun loadData() {//Simulation de chargement de donnée

        runInProgress.value = true
        errorMessage.value = ""

        viewModelScope.launch(Dispatchers.Default) {

            try {

                val listWeather = WeatherAPI.loadWeatherAround(searchText.value)
                val listPicture = listWeather.map {
                    PictureBean(
                        it.weather.getOrNull(0)?.icon ?: "",
                        it.name,
                        "Il fait ${it.main.temp}° à ${it.name} avec un vent de ${it.wind.speed} m/s"
                    )
                }
                myList.clear()
                //Mon appel d'API
                myList.addAll(listPicture) //Charge la liste en mode mélangé
            } catch (e: Exception) {
                e.printStackTrace()
                errorMessage.value = "Erreur : ${e.message}"
            }

            runInProgress.value = false
        }

    }
}