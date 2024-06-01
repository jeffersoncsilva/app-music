package com.jefferson.appmusic.ui.telas

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.constraintlayout.compose.ConstraintLayout
import com.jefferson.appmusic.R
import com.jefferson.appmusic.ui.componentes.CampoLogin
import com.jefferson.appmusic.viewmodels.LoginViewModel

@Composable
fun LoginScreen(vm: LoginViewModel?){
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.primaryContainer)
    ) {
        val (loginCard, logo) = createRefs()
        val state by vm?.uiState!!.collectAsState()

        Image(
            modifier = Modifier
                .clip(CircleShape)
                .constrainAs(logo) {
                    top.linkTo(parent.top)
                    bottom.linkTo(loginCard.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },
            bitmap = ImageBitmap.imageResource(id = R.drawable.logo),
            contentScale = ContentScale.Crop,
            contentDescription = stringResource(id = R.string.logo_descricao)
        )

        CampoLogin(
            email = state.currentEmailState,
            senha = state.currentSenhaState,
            onUpdateEmail = { vm?.updateEmail(it) },
            onUpdateSenha = { vm?.updateSenha(it) },
            onLoginClick = { vm?.loginClick() },
            modifier = Modifier.constrainAs(loginCard){
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
        )

    }
}

@Preview
@Composable
fun LoginScreenPreview(){
    LoginScreen(null)
}