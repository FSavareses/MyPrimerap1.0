package com.example.myprimerap1.ui.util

sealed class LoginUIState{
    object Idle: LoginUIState()
    object Loading: LoginUIState()
    data class Success(val isNewUser: Boolean): LoginUIState()
    data class Error(val msg: String): LoginUIState()

}
