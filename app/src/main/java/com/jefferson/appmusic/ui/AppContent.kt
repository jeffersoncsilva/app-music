package com.jefferson.appmusic.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.jefferson.appmusic.R
import com.jefferson.appmusic.navegacao.Tela
import com.jefferson.appmusic.ui.appdrawer.AppDrawer
import com.jefferson.appmusic.ui.appsbars.BottomNavigationComponent
import com.jefferson.appmusic.ui.telas.HomeScreen
import com.jefferson.appmusic.ui.telas.LoginScreen
import com.jefferson.appmusic.ui.telas.TelaConfiguracoes
import com.jefferson.appmusic.viewmodels.ConfiguracoesViewModel
import com.jefferson.appmusic.viewmodels.HomeViewModel
import com.jefferson.appmusic.viewmodels.LoginViewModel
import com.jefferson.appmusic.viewmodels.MainViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun AppContent(viewModel: LoginViewModel, vmHome: HomeViewModel, vmConfig: ConfiguracoesViewModel?){
    val snackBarHostState = remember { SnackbarHostState() }
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val coroutineScope: CoroutineScope = rememberCoroutineScope()
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
            Scaffold(
                topBar = { TopAppBar(Tela.fromRoute(navBackStackEntry?.destination?.route), drawerState, coroutineScope) },
                snackbarHost = { SnackbarHost(hostState = snackBarHostState) },
                bottomBar = {
                    BottomNavigationComponent(navController = navController)
                },
                content = { padding ->
                    MainScreenContainer(
                        navController = navController,
                        vm = viewModel,
                        vmHome= vmHome,
                        vmConfig = vmConfig,
                        modifier = Modifier.padding(padding)
                    )
                }
            )
}

@Composable
private fun MainScreenContainer(navController: NavHostController,vmConfig: ConfiguracoesViewModel?, vm: LoginViewModel?, vmHome: HomeViewModel?, modifier: Modifier = Modifier){
    Surface(
        modifier = modifier,
        color = MaterialTheme.colorScheme.background
    ) {
        NavHost(navController = navController, startDestination = Tela.Login.rota){
            composable(Tela.Login.rota) { LoginScreen(vm) }
            composable(Tela.Home.rota) { HomeScreen(vm = vmHome) }
            composable(Tela.Configuracoes.rota){
                TelaConfiguracoes(vmConfig)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBar(tela: Tela, scaffoldState: DrawerState, coroutineScope: CoroutineScope){
    androidx.compose.material3.TopAppBar(
        title = { Text(text = stringResource(id = tela.tituloResourceId)) },
        navigationIcon = {
            IconButton(onClick = {
                coroutineScope.launch {
                    scaffoldState.close()
                }
            }) {
                Icon(
                    imageVector = Icons.Filled.AccountCircle,
                    tint = Color.LightGray,
                    contentDescription = stringResource(id = R.string.home))
            }
        }
    )
}
