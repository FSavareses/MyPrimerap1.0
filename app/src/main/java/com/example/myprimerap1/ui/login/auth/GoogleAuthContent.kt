package com.example.myprimerap1.ui.login.auth

import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.example.myprimerap1.R
import com.example.myprimerap1.ui.login.ui.GoogleLoginButton
import com.example.myprimerap1.ui.login.ui.LoginViewModel

@Composable
fun GoogleAuthContent(viewModel: LoginViewModel) {
    val context = LocalContext.current
    val webclientId = stringResource(id = R.string.default_web_client_id)


    val launcher =
        rememberLauncherForActivityResult(contract = ActivityResultContracts.StartActivityForResult()) {
            viewModel.taskGoogleCall(it.data)
        }


    GoogleLoginButton(
        onClick = {
            val signInIntent = viewModel.getGoogleSignInIntent(webclientId,context)
            launcher.launch(signInIntent)
        })

}