package com.example.a24_02_supvincinantes

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.a24_02_supvincinantes.model.PictureBean
import com.example.a24_02_supvincinantes.model.pictureList
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    val searchText = mutableStateOf("")
    val myList = mutableStateListOf<PictureBean>()


    val selectedPicture = mutableStateOf<PictureBean?>(null)

    fun uploadSearchText(newText: String) {
        searchText.value = newText
    }

    fun loadData() {//Simulation de chargement de donnée
        myList.clear()

        viewModelScope.launch(Dispatchers.Default) {
            //TODO
            //Mon appel d'API
            myList.addAll(pictureList.shuffled()) //Charge la liste en mode mélangé
        }



    }
}