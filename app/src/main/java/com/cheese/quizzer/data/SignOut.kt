package com.cheese.quizzer.data

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.cheese.quizzer.ViewModelAuth
import com.cheese.quizzer.presentation.navigation.Routes

@Composable
fun SignOutButton(authViewModel: ViewModelAuth ) {
    Button(onClick = { authViewModel.SignOut()}) {
        Text("Sign Out")
    }

}