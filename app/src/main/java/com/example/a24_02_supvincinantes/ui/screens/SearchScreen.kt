package com.example.a24_02_supvincinantes.ui.screens

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.a24_02_supvincinantes.model.PictureBean
import com.example.a24_02_supvincinantes.model.pictureList
import com.example.a24_02_supvincinantes.ui.theme._24_02_SupVinciNantesTheme

//Code affiché dans la Preview, thème claire, thème sombre
@Preview(showBackground = true, showSystemUi = true)
@Preview(showBackground = true, showSystemUi = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun SearchScreenPreview() {
    _24_02_SupVinciNantesTheme {
        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
            SearchScreen()
        }
    }
}

//Composable représentant l'ensemble de l'écran
@Composable
fun SearchScreen() {
    //Couleur à retirer lors de l'utilisation des thèmes de couleur
    Column(modifier = Modifier.background(Color.LightGray)) {
        PictureRowItem(data = pictureList[0])
    }
}

//Composable affichant 1 PictureBean
@Composable
fun PictureRowItem(modifier: Modifier = Modifier, data: PictureBean) {
    //TODO
    Text(
        text = "Hello World",
    )
}