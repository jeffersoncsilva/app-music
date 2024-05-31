package com.jefferson.appmusic.ui.componentes.basicos

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import com.jefferson.appmusic.R


@Composable
fun InputTextNormal(hint: String, aoMudarValor: () -> Unit = { }){
    var text by rememberSaveable { mutableStateOf("") }

    TextField(
        value = text,
        onValueChange = { text = it },
        label = { Text(hint) },
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        colors = TextFieldDefaults.colors(
            unfocusedContainerColor = MaterialTheme.colorScheme.primaryContainer,
            focusedContainerColor = MaterialTheme.colorScheme.primaryContainer,
            focusedLabelColor = MaterialTheme.colorScheme.primary,
            unfocusedLabelColor = MaterialTheme.colorScheme.primary,
            unfocusedTextColor = MaterialTheme.colorScheme.primary,
            focusedTextColor = MaterialTheme.colorScheme.primary
        )
    )
}

@Composable
fun InputTextPassword(hint: String){
    var password by rememberSaveable { mutableStateOf("") }
    var passwordHidder by rememberSaveable { mutableStateOf(true) }
    TextField(
        value = password,
        onValueChange = { password = it },
        singleLine = true,
        label = { Text(hint) },
        visualTransformation = if(passwordHidder) PasswordVisualTransformation() else VisualTransformation.None,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        trailingIcon = {
            IconButton(
                onClick = { passwordHidder = !passwordHidder }){
                val visibilityIcon = if(passwordHidder)  ImageVector.vectorResource(id = R.drawable.ic_visibility) else ImageVector.vectorResource(id = R.drawable.ic_visibility_off)
                val description = if(passwordHidder) "MOSTRAR SENHA" else "ESCONDER SENHA"
                Icon(imageVector = visibilityIcon, contentDescription = description)
            }
        },
        colors = TextFieldDefaults.colors(
            unfocusedContainerColor = MaterialTheme.colorScheme.primaryContainer,
            focusedContainerColor = MaterialTheme.colorScheme.primaryContainer,
            focusedLabelColor = MaterialTheme.colorScheme.primary,
            unfocusedLabelColor = MaterialTheme.colorScheme.primary,
            unfocusedTextColor = MaterialTheme.colorScheme.primary,
            focusedTextColor = MaterialTheme.colorScheme.primary
        )
    )
}

@Preview
@Composable
fun InputTextNormalPreview(){
    InputTextNormal(hint = "Nome")
}

@Preview
@Composable
fun InputTextPasswordPreview(){
    InputTextPassword(hint = "Senha")
}
