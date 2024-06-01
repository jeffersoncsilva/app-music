package com.jefferson.appmusic.ui.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import com.jefferson.appmusic.ui.AppContent
import com.jefferson.appmusic.ui.telas.LoginScreen
import com.jefferson.appmusic.ui.theme.AppMusicTheme
import com.jefferson.appmusic.viewmodels.ConfiguracoesViewModel
import com.jefferson.appmusic.viewmodels.HomeViewModel
import com.jefferson.appmusic.viewmodels.LoginViewModel
import com.jefferson.appmusic.viewmodels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel : MainViewModel by viewModels()
    private val vmConfig: ConfiguracoesViewModel by viewModels()
    private val vmHome: HomeViewModel by viewModels()
    private val loginViewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppMusicTheme {
                AppContent(viewModel = loginViewModel, vmHome = vmHome, vmConfig = vmConfig)
            }
        }
    }
}