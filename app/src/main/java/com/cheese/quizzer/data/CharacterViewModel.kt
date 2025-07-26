package com.cheese.quizzer.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CharacterViewModel : ViewModel() {
    private val _characters = MutableStateFlow<Character?>(null)
    val character: StateFlow<Character?> = _characters

    private val _loading = MutableStateFlow(true)
    val isLoading: StateFlow<Boolean> = _loading

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error

    init {
        fetchCharacter(1)
    }

    private fun fetchCharacter(id: Int) {
        viewModelScope.launch {
            _loading.value = true
            _error.value = null
            try {
                val response =
                    RetrofitSingleton.api.getCharacter(1)
                    _characters.value = response
            } catch (e: Exception) {
                _error.value = "Falha ao Conectar ao servidor"
            } finally {
                _loading.value = false
            }
        }
    }
}
