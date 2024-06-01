package com.jefferson.appmusic.viewmodels

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jefferson.appmusic.MainApp
import com.jefferson.appmusic.navegacao.AppMusicNavegacao
import com.jefferson.appmusic.navegacao.HOME
import com.jefferson.appmusic.navegacao.Tela
import com.jefferson.appmusic.ui.activities.Evento
import com.jefferson.appmusic.ui.activities.MainActivity
import com.jefferson.appmusic.ui.telas.LoginUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor() : ViewModel() {
    private val _uiState = MutableStateFlow(LoginUiState())
    val uiState: StateFlow<LoginUiState> = _uiState.asStateFlow()

    private val _eventos = MutableSharedFlow<Evento>()
    val eventos: SharedFlow<Evento> = _eventos

    var senha by mutableStateOf("")
        private set
    var email by mutableStateOf("")
        private set

    fun updateEmail(email: String){
        this.email = email
        _uiState.value = _uiState.value.copy(currentEmailState = email)
    }

    fun updateSenha(senha: String){
        this.senha = senha
        _uiState.value = _uiState.value.copy(currentSenhaState = senha)
    }


    fun loginClick(){
        if(email.isNotEmpty() && senha.isNotEmpty()){
            viewModelScope.launch {
                _eventos.emit(Evento.LoginComSucesso)
            }
        }
    }
}