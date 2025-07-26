package com.cheese.quizzer.data

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.cheese.quizzer.ViewModelAuth

@Composable
fun CharacterScreen(navController: NavHostController,authViewModel: ViewModelAuth, characterViewModel: CharacterViewModel = viewModel()) {
    val character by characterViewModel.character.collectAsState()
    val loading by characterViewModel.isLoading.collectAsState()
    val error by characterViewModel.error.collectAsState()

    Surface {
        if (loading) {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator(color = MaterialTheme.colorScheme.primary)
            }
        } else if (error != null) {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text(text = error ?: "Unknown error", color = MaterialTheme.colorScheme.error)
            }
        } else {
            CharacterCard(character = character!!)
        }

        SignOutButton(authViewModel = ViewModelAuth())
    }
}

@Composable
fun CharacterCard(character: Character) {
    Card(modifier = Modifier.fillMaxSize()) {
        Row (verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(16.dp)) {
                AsyncImage(
                    model = character.image,
                    contentDescription = null,
                    modifier = Modifier.size(100.dp)
                )
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(text = character.name, style = MaterialTheme.typography.titleLarge)
                Text(text = character.status, style = MaterialTheme.typography.bodyMedium)
            }
        }
    }
}
