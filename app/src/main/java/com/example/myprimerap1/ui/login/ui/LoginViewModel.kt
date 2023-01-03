package com.example.myprimerap1.ui.login.ui

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myprimerap1.R
import com.example.myprimerap1.ui.util.LoginUIState
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthCredential
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch


class LoginViewModel : ViewModel() {

    val loginUIState = MutableStateFlow<LoginUIState>(LoginUIState.Idle)

    fun signWithCredential(credential: AuthCredential) = viewModelScope.launch {
        try {
            loginUIState.emit(LoginUIState.Loading)
            Firebase.auth.signInWithCredential(credential)

        } catch (e: Exception) {
            loginUIState.emit(LoginUIState.Error(e.localizedMessage.orEmpty()))
        }
    }

    fun taskGoogleCall(intent: Intent?) {
        val task = GoogleSignIn.getSignedInAccountFromIntent(intent)
        task.getResult(ApiException::class.java)?.apply {
            val credential = GoogleAuthProvider.getCredential(idToken.orEmpty(), null)
            signWithCredential(credential)


        }
    }

    fun getGoogleSignInIntent(webclientId: String, context: Context): Intent {
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(webclientId)
            .requestEmail()
            .build()
        val googleSignInClient = GoogleSignIn.getClient(context, gso)

        return googleSignInClient.signInIntent
    }



}