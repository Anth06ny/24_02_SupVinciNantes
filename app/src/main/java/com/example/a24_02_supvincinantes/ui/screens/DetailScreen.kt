package com.example.a24_02_supvincinantes.ui.screens

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.bumptech.glide.integration.compose.placeholder
import com.example.a24_02_supvincinantes.MainViewModel
import com.example.a24_02_supvincinantes.R
import com.example.a24_02_supvincinantes.ui.theme._24_02_SupVinciNantesTheme

//Code affiché dans la Preview, thème claire, thème sombre
@Preview(showBackground = true, showSystemUi = true)
@Preview(showBackground = true, showSystemUi = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun DetailScreenPreview() {
    _24_02_SupVinciNantesTheme {
        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
            DetailScreen(0)
        }
    }
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable //Position du PictureBean dans la liste
fun DetailScreen(
    positionPicture: Int,
    navController: NavHostController? = null,
    viewModel : MainViewModel = viewModel()
    ){

   //val pictureBean = viewModel.myList.get(positionPicture)
    //le !! permet d'indiquer au compilateur de ne plus verifier la nullité
   val pictureBean = viewModel.selectedPicture.value!!


    Column(horizontalAlignment = Alignment.CenterHorizontally,
    modifier = Modifier.padding(8.dp)
    ) {
        Text(pictureBean.text
, color = MaterialTheme.colorScheme.primary,
            fontSize = 40.sp
        )

        GlideImage(
            model = pictureBean.url,
            //Dans string.xml
            //contentDescription = getString(R.string.picture_of_cat),
            //En dur
            contentDescription = "une photo de chat",
            loading = placeholder(R.mipmap.ic_launcher_round), // Image de chargement
            // Image d'échec. Permet également de voir l'emplacement de l'image dans la Preview
            failure = placeholder(R.mipmap.ic_launcher),
            contentScale = ContentScale.Fit,
            //même autres champs qu'une Image classique
            modifier = Modifier.fillMaxWidth()
                .weight(2f)
        )

        Text(pictureBean.longText,
modifier = Modifier.weight(1f)
        )

        Button(
            onClick = {
                navController?.popBackStack()
                      },
            contentPadding = ButtonDefaults.ButtonWithIconContentPadding
        ) {
            Icon(
                Icons.Filled.ArrowBack,
                contentDescription = "Localized description",
                modifier = Modifier.size(ButtonDefaults.IconSize)
            )
            Spacer(Modifier.size(ButtonDefaults.IconSpacing))
            Text("Retour")
        }

    }
}