package com.cheese.quizzer.screen

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.cheese.quizzer.ViewModelAuth

@Composable
fun ScreenMain(modifier: Modifier){
    val navController = rememberNavController()

    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = Routes.Login.route) {

        composable(Routes.Login.route) {
            LoginPage(navController = navController)
        }
        composable(Routes.SignUp.route) {
            SignUp(navController = navController, authViewModel = ViewModelAuth())
        }
        composable(Routes.ForgotPassword.route) {
            ForgotPassword(navController = navController)
        }

    }
}