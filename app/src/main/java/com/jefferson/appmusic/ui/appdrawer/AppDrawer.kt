package com.jefferson.appmusic.ui.appdrawer

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.jefferson.appmusic.navegacao.Tela

@Composable
fun AppDrawer(modifier: Modifier, onTelaSelecionada: (Tela) -> Unit){
    Column(
        modifier = modifier.fillMaxSize().background(color = MaterialTheme.colorScheme.surface)
    ) {

    }
}