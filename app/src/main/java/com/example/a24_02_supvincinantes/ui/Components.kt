package com.example.a24_02_supvincinantes.ui

import android.content.res.Configuration
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.a24_02_supvincinantes.ui.theme._24_02_SupVinciNantesTheme


@Preview(showSystemUi = true)
@Preview(showSystemUi = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun MyErrorPreview() {
    _24_02_SupVinciNantesTheme {
        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
            MyError(errorMessage = "Coucou")
        }
    }
}

@Composable
fun MyError(modifier: Modifier = Modifier, errorMessage: String) {

    AnimatedVisibility(
        modifier = modifier,
        visible = errorMessage.isNotBlank()) {
        Text(
            modifier = modifier.fillMaxWidth().background(MaterialTheme.colorScheme.error).padding(8.dp),
            color = MaterialTheme.colorScheme.onError,
            text = errorMessage,
            textAlign = TextAlign.Center

        )
    }


}