package com.ph30891.asm_ph30891.view.navigator

sealed class BottomBarScreen(val screen: String) {
    data object Home : BottomBarScreen("home")
    data object Favourite : BottomBarScreen("favourite")
    data object Notification : BottomBarScreen("notification")
    data object Personal : BottomBarScreen("personal")
}