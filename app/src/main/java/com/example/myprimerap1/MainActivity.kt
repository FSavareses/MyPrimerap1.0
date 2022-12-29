package com.example.myprimerap1

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.example.myprimerap1.ui.login.ui.LoginScreen
import com.example.myprimerap1.ui.login.ui.LoginViewModel
import com.example.myprimerap1.ui.theme.MyPrimerap1Theme
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.tasks.Task


class MainActivity : ComponentActivity() {
//    private val auth by lazy{
//        Firebase.auth
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel: LoginViewModel by viewModels()
            MyPrimerap1Theme {

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                )
                {
                    LoginScreen(viewModel)

                 }
            }
        }
    }
//      EN PROCESO

}
