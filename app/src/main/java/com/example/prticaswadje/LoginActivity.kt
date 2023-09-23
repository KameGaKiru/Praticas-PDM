package com.example.prticaswadje

import android.app.Activity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.prticaswadje.ui.theme.PráticasWadjeTheme

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title = "Login Activity"
        setContent {
            PráticasWadjeTheme {

                // Chame a função LoginPage
                LoginPage()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Preview(showBackground = true)
@Composable
fun LoginPage(modifier: Modifier = Modifier) {
    var email by rememberSaveable { mutableStateOf("") }
    var senha by rememberSaveable { mutableStateOf("") }
    val activity = LocalContext.current as? Activity
    LocalSoftwareKeyboardController.current

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Bem-vindo/a!",
            fontSize = 24.sp
        )

        //adcionar entre os componentes
        Spacer(modifier = Modifier.size(24.dp))

        OutlinedTextField(
            value = email,
            onValueChange = { newEmail ->
                email = newEmail
            },
            label = { Text("Digite seu e-mail") },

            //pegar toda a largura
            modifier = Modifier.fillMaxWidth()
        )

        //adcionar entre os componentes
        Spacer(modifier = Modifier.size(24.dp))

        OutlinedTextField(
            value = senha,
            onValueChange = { newSenha ->
                senha = newSenha
            },
            label = { Text("Digite sua senha") },

            //pegar toda a largura
            modifier = Modifier.fillMaxWidth(),

            visualTransformation = PasswordVisualTransformation()
        )

        //adcionar entre os componentes
        Spacer(modifier = Modifier.size(24.dp))

        Button(
            onClick = {
                if (email.isNotEmpty() && senha.isNotEmpty()) {
                    Toast.makeText(activity, "Login OK!", Toast.LENGTH_LONG).show()
                }
            },
            enabled = email.isNotEmpty() && senha.isNotEmpty()
        ) {
            Text("Login")
        }

        //adcionar entre os componentes
        Spacer(modifier = Modifier.size(24.dp))

        Button(
            onClick = {
                email = ""
                senha = ""
            },
            enabled = email.isNotEmpty() || senha.isNotEmpty()
        ) {
            Text("Limpar")
        }
    }
}
