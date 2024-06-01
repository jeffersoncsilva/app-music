package com.jefferson.appmusic.ui.appsbars

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import com.jefferson.appmusic.R
import com.jefferson.appmusic.navegacao.Tela

@Composable
fun BottomNavigationComponent(navController: NavHostController, modifier: Modifier = Modifier){
    var selectedItem by remember { mutableStateOf(0) }
    val items = listOf(
        NavigationItem(0, R.drawable.ic_playlist, R.string.playlists_icon, Tela.Playlists),
        NavigationItem(1, R.drawable.ic_home, R.string.home_icon, Tela.Home),
        NavigationItem(2, R.drawable.ic_settings, R.string.settings, Tela.Configuracoes)
    )

    NavigationBar(modifier = modifier) {
        items.forEachIndexed { idx, item ->
            NavigationBarItem(
                icon = {
                    Icon(
                        imageVector = ImageVector.vectorResource(id = item.vectorResourceId),
                        contentDescription = stringResource(id = item.contentDescriptionResource)
                    )
                },
                label = {
                    Text(text = stringResource(id = item.contentDescriptionResource))
                },
                selected = selectedItem == idx,
                onClick = {
                    selectedItem = idx
                    navController.navigate(item.tela.rota){
                        popUpTo(navController.graph.findStartDestination().id){
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}

private data class NavigationItem(
    val index: Int,
    val vectorResourceId: Int,
    val contentDescriptionResource: Int,
    val tela: Tela
)