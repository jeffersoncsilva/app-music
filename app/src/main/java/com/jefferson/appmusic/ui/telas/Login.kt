package com.jefferson.appmusic.ui.telas

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.constraintlayout.compose.ConstraintLayout
import com.jefferson.appmusic.R
import com.jefferson.appmusic.ui.componentes.CampoLogin

@Composable
fun LoginScreen(){
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.primaryContainer)
    ) {
        val (loginCard, logo) = createRefs()

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
            onLoginClick = { /*TODO*/ },
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
    LoginScreen()
}