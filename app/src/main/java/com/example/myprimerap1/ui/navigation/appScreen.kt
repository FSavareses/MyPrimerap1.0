package com.example.myprimerap1.ui.navigation

sealed class AppScreen (val route: String){
    object LoginScreen: AppScreen("login_screen")
    object HomeScreen: AppScreen("home_screen")
}