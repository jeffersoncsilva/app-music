package com.jefferson.appmusic.navegacao

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.jefferson.appmusic.R

const val LOGIN = "login"
const val HOME = "home"
const val PLAYLISTS = "playlists"
const val CONFIG = "config"
const val PLAYER_MUSICA_TELA = "play_music"

sealed class Tela(val tituloResourceId: Int, val rota: String){
    object Login: Tela(R.string.login, LOGIN)
    object Home : Tela(R.string.home, HOME)
    object Playlists : Tela(R.string.playlists, PLAYLISTS)
    object Configuracoes : Tela(R.string.configuracoes, CONFIG)
    object PlayerMusicaTela : Tela(R.string.player_musica_tela, PLAYER_MUSICA_TELA)

    companion object {
        fun fromRoute(route: String?) : Tela {
            return when(route){
                Home.rota -> Home
                Playlists.rota -> Playlists
                Configuracoes.rota -> Configuracoes
                PlayerMusicaTela.rota -> Playlists
                else -> Home
            }
        }
    }
}

object AppMusicNavegacao {
    var telaCorrente: MutableState<Tela> = mutableStateOf(Tela.Login)

    fun navegaPara(destino: Tela){
        telaCorrente.value = destino
    }
}