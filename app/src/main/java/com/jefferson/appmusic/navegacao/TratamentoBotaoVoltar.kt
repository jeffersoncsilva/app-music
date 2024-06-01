package com.jefferson.appmusic.navegacao

import androidx.activity.ComponentActivity
import androidx.activity.OnBackPressedCallback
import androidx.activity.OnBackPressedDispatcherOwner
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.platform.LocalLifecycleOwner

private val LocalBackPressedDispathcer = staticCompositionLocalOf<OnBackPressedDispatcherOwner?> { null }

private class ComposableBackhandler(enabled: Boolean) : OnBackPressedCallback(enabled){
    lateinit var onBackPressed: () -> Unit

    override fun handleOnBackPressed() {
        onBackPressed()
    }
}

@Composable
internal fun Handler(enabled: Boolean = true, onBackPressed: () -> Unit){
    val dispacher = (LocalBackPressedDispathcer.current ?: return).onBackPressedDispatcher

    val handler = remember {
        ComposableBackhandler(enabled)
    }

    DisposableEffect(dispacher) {
        dispacher.addCallback(handler)
        onDispose { handler.remove() }
    }

    LaunchedEffect(enabled) {
        handler.isEnabled = enabled
        handler.onBackPressed = onBackPressed
    }
}

@Composable
internal fun BackButtonHandler(onBackPressed: () -> Unit){
    CompositionLocalProvider(LocalBackPressedDispathcer provides LocalLifecycleOwner.current as ComponentActivity) {
        Handler {
            onBackPressed()
        }
    }
}