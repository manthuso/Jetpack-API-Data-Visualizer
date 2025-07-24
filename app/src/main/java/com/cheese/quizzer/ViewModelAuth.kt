package com.cheese.quizzer

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthInvalidUserException


class ViewModelAuth : ViewModel() {

    private val auth : FirebaseAuth = FirebaseAuth.getInstance()

    private val _authState = MutableLiveData<AuthState>()
    val authState : LiveData<AuthState> = _authState

    init {
        checkAuthStatus()
    }

    //Verifica se o user está autenticado
    fun checkAuthStatus() {
        if(auth.currentUser==null) {
            _authState.value = AuthState.UnAuthenticated
        } else {
            _authState.value = AuthState.Authenticated
        }
    }

    fun resetAuthState() {
        _authState.value = AuthState.UnAuthenticated
    }


    //Faz Login do user
    fun Login(email : String, password : String) {
        _authState.value = AuthState.Loading

        //Verifica se os campos de login estão vazios
        if(email.isEmpty() || password.isEmpty()) {
            _authState.value = AuthState.Failure("Email or Password can't be empty")
            return
    }
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener{ task ->
                if(task.isSuccessful) {
                    _authState.value = AuthState.Authenticated
                } else {
                    val exception = task.exception
                    when (exception) {
                        is FirebaseAuthInvalidCredentialsException -> {
                            _authState.value = AuthState.Failure("Invalid Email or Password")
                        }
                        is FirebaseAuthInvalidUserException -> {
                            _authState.value = AuthState.Failure("User not found")
                            }
                        else -> {
                            _authState.value = AuthState.Failure("Something went wrong, try again or later")
                        }
                    }
                }
            }
    }

    fun SignUp(email : String, password : String) {
        _authState.value = AuthState.Loading

        //Verifica se os campos de login estão vazios
        if(email.isEmpty() || password.isEmpty()) {
            _authState.value = AuthState.Failure("Email or Password can't be empty")
            return
        }
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener{ task ->
                if(task.isSuccessful) {
                    _authState.value = AuthState.Authenticated
                } else {
                    _authState.value = AuthState.Failure("Something went wrong")
                }
            }
}

    fun SignOut() {
        auth.signOut()
        _authState.value = AuthState.UnAuthenticated
    }

//Define UnAuth, Auth and Success/Failure Msgs
sealed class AuthState{
    object UnAuthenticated : AuthState()
    object Authenticated : AuthState()
    object Loading : AuthState()
    data class Failure(val message : String? = null) : AuthState()


}
}
