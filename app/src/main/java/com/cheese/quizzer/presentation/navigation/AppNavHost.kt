package com.cheese.quizzer.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.cheese.quizzer.ViewModelAuth
import com.cheese.quizzer.presentation.ForgotPassword
import com.cheese.quizzer.presentation.home.HomePage
import com.cheese.quizzer.presentation.login.LoginPage
import com.cheese.quizzer.presentation.signup.SignUp

@Composable
fun ScreenMain(modifier: Modifier){
    val navController = rememberNavController()

    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = Routes.Login.route) {

        composable(Routes.Login.route) {
            LoginPage(navController = navController, authViewModel = ViewModelAuth())
        }
        composable(Routes.SignUp.route) {
            SignUp(navController = navController, authViewModel = ViewModelAuth())
        }
        composable(Routes.ForgotPassword.route) {
            ForgotPassword(navController = navController)
        }
        composable(Routes.HomePage.route) {
            HomePage(navController = navController, authViewModel = ViewModelAuth())

        }

    }
}