package com.example.myprimerap1.ui.login.ui

import android.app.Activity
import android.content.Intent
import android.util.Log
import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myprimerap1.R
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import kotlinx.coroutines.delay


class LoginViewModel : ViewModel() {

    //FIREBASE GOOGLE
    private val isLoadingx = MutableLiveData(false)

    fun isLoadingx() : LiveData<Boolean> = isLoadingx

    fun loginWithGoogle(activity: Activity){

        _isLoading.postValue(true)

        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(activity.getString(R.string.default_web_client_id))
            .requestEmail()
            .build()

        val client = GoogleSignIn.getClient(activity, gso);

        val signInIntent: Intent = client.signInIntent
        activity.startActivityForResult(signInIntent, 1)

//        val account = client.getLastSignedInAccount(this)
//        updateUI(account)
    }


    //FIREBASE GOOGLE


    private val _email = MutableLiveData<String>()
    val email: LiveData<String> = _email

    private val _password = MutableLiveData<String>()
    val password: LiveData<String> = _password

    private val _loginEnable = MutableLiveData<Boolean>()
    val loginEnable: LiveData<Boolean> = _loginEnable

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading


    fun onLoginChanged(email: String, password: String) {
        _email.value = email
        _password.value = password
        _loginEnable.value = isValidEmail(email) && isValidPassword(password)


    }

    private fun isValidPassword(password: String): Boolean = password.length > 6

    private fun isValidEmail(email: String): Boolean =
        Patterns.EMAIL_ADDRESS.matcher(email).matches()

    suspend fun onLoginSelected() {
        _isLoading.value = true
        delay(4000)
        _isLoading.value = false
    }

    fun finishLogin(accountTask: Task<GoogleSignInAccount>) {
        try {
            val account: GoogleSignInAccount = accountTask.getResult(ApiException::class.java)

           account?.idToken?.let { token ->
               val auth = FirebaseAuth.getInstance()
               val credential = GoogleAuthProvider.getCredential(token, null)
                auth.signInWithCredential(credential)
                    .addOnCompleteListener{ task ->
                        if (task.isSuccessful){
                            Log.d("ACA", "Ingreso")
                        }else{
                            _isLoading.value = true
                        }

                    }
           }
        } catch (e: ApiException) {


            _isLoading.value = true
        }

        _isLoading.value = false
    }

}