package com.example.musicapp

import android.graphics.drawable.Icon
import androidx.annotation.DrawableRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screen(val title: String , val route:String) {

    sealed class BottomScreen(val bTitle : String , val bRoute:String ,  val selectedIcon : ImageVector ,val disSelectedIcon : ImageVector)
        :Screen(bTitle,bRoute){
            object Home : BottomScreen("Home","home", Icons.Filled.Home,Icons.Default.Home)
            object Library : BottomScreen("Library","library",Icons.Filled.List,Icons.Default.List)
            object Browse : BottomScreen("Browse","browse",Icons.Filled.Search,Icons.Default.Search)
        }

    sealed class DrawerScreen(val dTitle : String , val dRoute:String , @DrawableRes val icon : Int )
        :Screen(dTitle,dRoute){
            object Account : DrawerScreen(
                "Account",
                "account",
                R.drawable.ic_account
            )
            object Subcription : DrawerScreen(
            "Subsciption",
            "subscribe",
            R.drawable.ic_subscribe
        )
        object AddAccount : DrawerScreen(
            "Add Account",
            "add_account",
            R.drawable.baseline_person_add_alt_1_24
        )
        }
}


val screensInDrawwer = listOf(
    Screen.DrawerScreen.Account,
    Screen.DrawerScreen.AddAccount,
    Screen.DrawerScreen.Subcription,
)

val screensInBottom = listOf(
    Screen.BottomScreen.Home,
    Screen.BottomScreen.Library,
    Screen.BottomScreen.Browse,
)

