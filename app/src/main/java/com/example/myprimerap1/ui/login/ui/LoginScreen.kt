package com.example.myprimerap1.ui.login.ui


import android.app.Activity
import android.content.Intent
import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.myprimerap1.R
import com.example.myprimerap1.ui.login.auth.GoogleAuthContent
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import kotlinx.coroutines.launch

@Composable
fun LoginScreen(viewModel: LoginViewModel) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(top = 58.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        HeaderImage(Modifier.align(Alignment.CenterHorizontally))
//        EmailField("email") { viewModel.onLoginChanged(it, password) }
//        PasswordField(password) { viewModel.onLoginChanged(email, it) }
//        ForgotPassword(Modifier.align(Alignment.End))
//        LoginButton(loginEnable)
        GoogleAuthContent(viewModel = viewModel)


    }
}


fun loginWithGoogle(activity: Activity) {


    val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
        .requestIdToken(activity.getString(R.string.default_web_client_id))
        .requestEmail()
        .build()

    val client = GoogleSignIn.getClient(activity, gso);


}



@Composable
fun GoogleLoginButton(
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        shape = RoundedCornerShape(50),

        colors = ButtonDefaults.buttonColors(backgroundColor = Color.White)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 15.dp)
        ) {

            Text(
                text = "GOoggle",
                fontSize = 16.sp,
                color = Color.Black,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
        }
    }
}

@Composable
fun LoginButton(loginEnable: Boolean, onLoginSelected: () -> Unit) {

    Button(
        onClick = { onLoginSelected() }, modifier = Modifier
            .fillMaxWidth()
            .height(46.dp)
            .padding(horizontal = 8.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color(0xE9FD3D2E),
            disabledBackgroundColor = Color(0x9048A7F1),
            contentColor = Color.White,
            disabledContentColor = Color.White
        ), enabled = loginEnable
    ) {
        Text(text = "Iniciar Sesión")
    }
}

@Composable
fun ForgotPassword(modifier: Modifier) {
    Text(text = "Olvidaste la contraseña",
        modifier = modifier
            .clickable { }
            .padding(top = 10.dp, end = 6.dp, bottom = 10.dp),
        fontSize = 12.sp,
        fontWeight = FontWeight.Bold,
        color = Color(0xFF0264B3)
    )
}

@Composable
fun PasswordField(password: String, onTextFieldChanged: (String) -> Unit) {

    TextField(
        value = password,
        onValueChange = { onTextFieldChanged(it) },
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 6.dp, vertical = 8.dp),
        placeholder = { Text(text = "Contraseña") },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        singleLine = true,
        maxLines = 1,
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color.Black,
            backgroundColor = Color(0xFFE9E7E7),
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        )
    )
}

@Composable
fun EmailField(email: String, onTextFieldChanged: (String) -> Unit) {

    TextField(
        value = email,
        onValueChange = { onTextFieldChanged(it) },
        modifier = Modifier
            .fillMaxWidth()
            .padding(6.dp),
        placeholder = { Text(text = "Email") },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        singleLine = true,
        maxLines = 1,
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color.Black,
            backgroundColor = Color(0xFFE9E7E7),
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        )
    )
}

@Composable
fun HeaderImage(modifier: Modifier) {
    androidx.compose.foundation.Image(
        painter = painterResource(id = R.drawable.fox),
        contentDescription = "Header",
        modifier = modifier
            .size(200.dp)
    )
}
