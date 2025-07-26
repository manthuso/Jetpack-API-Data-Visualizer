package com.cheese.quizzer.presentation.navigation

sealed class Routes(val route: String) {
    object Login : Routes("Login")
    object SignUp : Routes("SignUp")
    object ForgotPassword : Routes("ForgotPassword")
    object HomePage : Routes("HomePage")
    object CharacterScreen : Routes("CharacterScreen")
}