package com.example.musicapp

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainView(controller: NavController) {
    val viewModel: MainViewModel = viewModel()
    val scope: CoroutineScope = rememberCoroutineScope()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val navBackStackEntry by controller.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    val currentScreen by remember { viewModel.currentScreen }
    var title by remember { mutableStateOf(currentScreen.title) }
    var dialogOpen = remember { mutableStateOf(false) }

    val navigationIcon : @Composable () -> Unit ={
        if(currentRoute != Screen.DrawerScreen.Account.dRoute
            && currentRoute != Screen.DrawerScreen.Subcription.dRoute){
            IconButton(onClick = {
                scope.launch {
                    drawerState.open()
                }
            }) {
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = "Open Drawer"
                )
            }
        }else{
            IconButton(onClick = {
              controller.navigateUp()
            }) {
                Icon(
                    imageVector = Icons.Default.KeyboardArrowLeft,
                    contentDescription = null
                )
            }
        }
    }

    val bottomBar : @Composable () -> Unit = {//TODO UNDERSTAND THIS
        if( currentRoute != Screen.DrawerScreen.Account.dRoute
            && currentRoute != Screen.DrawerScreen.Subcription.dRoute){
           NavigationBar {
               screensInBottom.forEach {
                   item->
                   NavigationBarItem(
                       selected = currentRoute == item.route ,
                       onClick = {
                                 controller.navigate(item.bRoute)
                       },
                       icon = {
                           Icon(
                               imageVector = if(currentRoute == item.bRoute)
                                   item.selectedIcon else item.disSelectedIcon,
                               contentDescription = null
                           )
                       })
               }
           }
        }
    }

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet{
                screensInDrawwer.forEach {item->
                    NavigationDrawerItem(
                        label = {
                            Text(
                                text = item.dTitle,
                                style = MaterialTheme.typography.headlineSmall
                            )
                        },
                        selected = currentRoute == item.route ,
                        onClick = {
                            scope.launch {
                                                            drawerState.close()
                                                        }
                                                        if (item.route == Screen.DrawerScreen.AddAccount.route) {
                                                            dialogOpen.value = true
                                                        } else {
                                                            controller.navigate(item.route)
                                                            title = item.title
                                                        }
                        },
                        icon = {
                            Icon(painter = painterResource(id = item.icon),
                                contentDescription = item.dTitle,
                                modifier = Modifier.padding(end = 8.dp, top = 4.dp)
                            )
                        },
                        modifier = Modifier.padding(end = 16.dp)
                    )
                }


                }
        }
    ) {
        Scaffold(
            bottomBar = {
                        bottomBar()
            },
            topBar = {
                TopAppBar(
                    title = { Text(text = title) },
                    navigationIcon = {
                        navigationIcon()
                    }
                )
            }
        ) { innerPadding ->
            Navigation(
                navController = controller,
                viewModel = viewModel,
                pd = innerPadding
            )

            if (dialogOpen.value) {
                AccountDialog(
                    isEnabled = dialogOpen
                )
            }
        }
    }
}


