package com.cheese.quizzer.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.cheese.quizzer.ViewModelAuth
import com.cheese.quizzer.component.CustomTopAppBar

@Composable
fun SignUp(navController: NavHostController, authViewModel: ViewModelAuth) {


    Box(modifier = Modifier.fillMaxSize()) {
        ScaffoldWithTopBar(navController = navController, authViewModel)
    }
}

@Composable
fun ScaffoldWithTopBar(navController: NavHostController, authViewModel: ViewModelAuth) {
    val signupState by authViewModel.authState.observeAsState()

    LaunchedEffect(Unit) {
        authViewModel.resetAuthState()
    }

    LaunchedEffect(signupState) {
        if (signupState is ViewModelAuth.AuthState.Authenticated) {
            navController.navigate(Routes.Login.route) {
                popUpTo(navController.graph.startDestinationId) {
                    inclusive = true
                }
            }
        }
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center) {
        ClickableText(
            text = AnnotatedString("Already have account? Login Here"),
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(20.dp),
            onClick = { navController.navigate(Routes.Login.route) },
            style = TextStyle(
                fontSize = 16.sp,
                fontFamily = FontFamily.SansSerif,
                textDecoration = TextDecoration.Underline,
                color = androidx.compose.ui.graphics.Color.Blue
            )
        )
    }
    Box (modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center){
        Column(
            modifier = Modifier.padding(20.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val username = remember { mutableStateOf(TextFieldValue()) }
            val password = remember { mutableStateOf(TextFieldValue()) }

            Text(
                text = "Welcome!",
                style = TextStyle(fontSize = 40.sp, fontFamily = FontFamily.SansSerif)
            )

            Spacer(modifier = Modifier.height(20.dp))

            TextField(
                label = { Text(text = "Email/Username") },
                value = username.value,
                onValueChange = { username.value = it }
            )

            Spacer(modifier = Modifier.height(20.dp))

            TextField(
                label = { Text(text = "Password") },
                value = password.value,
                onValueChange = { password.value = it }
            )

            Spacer(modifier = Modifier.height(20.dp))

            Box(modifier = Modifier.padding(40.dp, 0.dp, 40.dp, 0.dp))


            if (signupState is ViewModelAuth.AuthState.Failure) {
                val mensagem = (signupState as ViewModelAuth.AuthState.Failure).message

                Text(
                    text = mensagem ?: "Email ou senha incorretos -teste-",
                    color = MaterialTheme.colorScheme.error,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
            }


            //Botão de Criar a Conta do user
            Button(
                onClick = {authViewModel.SignUp(username.value.text, password.value.text) },
                shape = RoundedCornerShape(50.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
            )
            { Text(text = "Create Account") }

            Spacer(modifier = Modifier.height(20.dp))
        }
    }
}

@Preview
@Composable
fun ScaffoldWithTopBarPreview() {
    ScaffoldWithTopBar(navController = rememberNavController(), authViewModel = ViewModelAuth())
}

