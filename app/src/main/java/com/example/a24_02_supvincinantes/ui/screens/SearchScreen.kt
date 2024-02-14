package com.example.a24_02_supvincinantes.ui.screens

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.bumptech.glide.integration.compose.placeholder
import com.example.a24_02_supvincinantes.R
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
    Column(modifier = Modifier
        .background(MaterialTheme.colorScheme.outline)
        .padding(8.dp)

    ) {

        SearchBar()

        Spacer(Modifier.size(8.dp))

        LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.weight(1f)) {
            items(pictureList.size) {
                PictureRowItem(data = pictureList[it])
            }
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement=Arrangement.Center) {

            Button(
                onClick = { /* Do something! */ },
                contentPadding = ButtonDefaults.ButtonWithIconContentPadding
            ) {
                Icon(
                    Icons.Filled.Clear,
                    contentDescription = "Localized description",
                    modifier = Modifier.size(ButtonDefaults.IconSize)
                )
                Spacer(Modifier.size(ButtonDefaults.IconSpacing))
                Text("Clear filter")
            }

            Spacer(Modifier.size(8.dp))

            Button(
                onClick = { /* Do something! */ },
                contentPadding = ButtonDefaults.ButtonWithIconContentPadding
            ) {
                Icon(
                    Icons.Filled.Send,
                    contentDescription = "Localized description",
                    modifier = Modifier.size(ButtonDefaults.IconSize)
                )
                Spacer(Modifier.size(ButtonDefaults.IconSpacing))
                Text("Load data")
            }
        }
    }
}

//Composable affichant 1 PictureBean
@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun PictureRowItem(modifier: Modifier = Modifier, data: PictureBean) {

    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.onPrimary)
    ) {

//Permission Internet nécessaire
        GlideImage(
            model = data.url,
            //Dans string.xml
            //contentDescription = getString(R.string.picture_of_cat),
            //En dur
            contentDescription = "une photo de chat",
            loading = placeholder(R.mipmap.ic_launcher_round), // Image de chargement
            // Image d'échec. Permet également de voir l'emplacement de l'image dans la Preview
            failure = placeholder(R.mipmap.ic_launcher),
            contentScale = ContentScale.Fit,
            //même autres champs qu'une Image classique
            modifier = Modifier
                .heightIn(max = 100.dp) //Sans hauteur il prendra tous l'écran
                .widthIn(max = 100.dp)
        )

        Column(
            modifier =
            Modifier.padding(8.dp)
        ) {
            Text(
                text = data.text,
                fontSize = 20.sp
            )
            Text(
                text = data.longText.take(20) + "...",
                fontSize = 14.sp,
                color = MaterialTheme.colorScheme.primary
            )
        }
    }


}


@Composable
fun SearchBar(modifier: Modifier = Modifier) {
    TextField(
        value = "", //Valeur par défaut
        onValueChange = {newValue->}, //Action
        leadingIcon = { //Image d'icone
            Icon(
                imageVector = Icons.Default.Search,
                tint = MaterialTheme.colorScheme.primary,
                contentDescription = null
            )
        },
        label = { Text("Enter text") }, //Texte d'aide qui se déplace
        //Comment le composant doit se placer
        modifier = modifier
            .fillMaxWidth() // Prend toute la largeur
            .heightIn(min = 56.dp) //Hauteur minimum
    )
}