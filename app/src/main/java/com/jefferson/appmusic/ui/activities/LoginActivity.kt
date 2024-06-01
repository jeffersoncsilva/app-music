package com.jefferson.appmusic.ui.activities

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.runtime.LaunchedEffect
import androidx.lifecycle.lifecycleScope
import com.jefferson.appmusic.navegacao.Tela
import com.jefferson.appmusic.ui.telas.LoginScreen
import com.jefferson.appmusic.ui.theme.AppMusicTheme
import com.jefferson.appmusic.viewmodels.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch

@AndroidEntryPoint
class LoginActivity : ComponentActivity() {
    private val vmLogin: LoginViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        lifecycleScope.launch {
            vmLogin.eventos.collectLatest {event ->
                when (event) {
                    Evento.LoginComSucesso -> iniciaActivityApp()
                    Evento.LoginComFalha -> {}
                }
            }
        }
        setContent {
            AppMusicTheme {
                LoginScreen(vm = vmLogin)
            }
        }
    }

    private fun iniciaActivityApp(){
        startActivity(Intent(baseContext, MainActivity::class.java).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK))
    }
}

sealed class Evento{
    object LoginComSucesso: Evento()
    object LoginComFalha: Evento()
}