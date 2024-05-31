package com.jefferson.appmusic.ui.componentes

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.jefferson.appmusic.R
import com.jefferson.appmusic.ui.componentes.basicos.BotaoBasico
import com.jefferson.appmusic.ui.componentes.basicos.InputTextNormal
import com.jefferson.appmusic.ui.componentes.basicos.InputTextPassword

@Composable
fun CampoLogin(onLoginClick: () -> Unit, modifier: Modifier = Modifier){
    Column(
        modifier = modifier,
        verticalArrangement =  Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        InputTextNormal(hint = stringResource(id = R.string.email))
        Spacer(modifier = Modifier.height(16.dp))
        InputTextPassword(hint = stringResource(id = R.string.password))
        Spacer(modifier = modifier.height(16.dp))
        BotaoBasico(nome = stringResource(id = R.string.logar_app), onClick = onLoginClick)
    }
}