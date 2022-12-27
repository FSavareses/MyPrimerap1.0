package com.example.myprimerap1.ui.login.ui

import android.app.Activity
import android.content.Intent
import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import kotlinx.coroutines.delay


class LoginViewModel : ViewModel() {

//    //FIREBASE GOOGLE
//    private val isLoadingx = MutableLiveData(false)
//
//    fun isLoadingx() : LiveData<Boolean> = isLoadingx
//
//    fun loginWithGoogle(activity: Activity){
//
//        _isLoading.postValue(true)
//
//        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
//            .requestEmail()
//            .build()
//
//        val client = GoogleSignIn.getClient(activity, gso);
//
//        val signInIntent: Intent = client.signInIntent
//        activity.startActivityForResult(signInIntent, 1)
//
////        val account = client.getLastSignedInAccount(this)
////        updateUI(account)
//    }
//
//
//    //FIREBASE GOOGLE
//
//
//    private val _email = MutableLiveData<String>()
//    val email: LiveData<String> = _email
//
//    private val _password = MutableLiveData<String>()
//    val password: LiveData<String> = _password
//
//    private val _loginEnable = MutableLiveData<Boolean>()
//    val loginEnable: LiveData<Boolean> = _loginEnable
//
//    private val _isLoading = MutableLiveData<Boolean>()
//    val isLoading: LiveData<Boolean> = _isLoading
//
//
//    fun onLoginChanged(email: String, password: String) {
//        _email.value = email
//        _password.value = password
//        _loginEnable.value = isValidEmail(email) && isValidPassword(password)
//
//
//    }
//
//    private fun isValidPassword(password: String): Boolean = password.length > 6
//
//    private fun isValidEmail(email: String): Boolean =
//        Patterns.EMAIL_ADDRESS.matcher(email).matches()
//
//    suspend fun onLoginSelected() {
//        _isLoading.value = true
//        delay(4000)
//        _isLoading.value = false
//    }
}