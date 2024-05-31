package com.jefferson.appmusic.ui.componentes.basicos

import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun BotaoBasico(nome: String, onClick: () -> Unit, modifier: Modifier = Modifier){
    Button(
        onClick = onClick,
        modifier = modifier
    ) {
        Text(text = nome)
    }
}

@Preview
@Composable
fun BotaoBasicoPreview(){
    BotaoBasico(nome = "Salvar", onClick = {  })
}