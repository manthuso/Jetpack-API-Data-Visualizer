package com.cheese.quizzer.data

import android.widget.Space
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun CharacterScreen(characterViewModel: CharacterViewModel = viewModel()) {
    val characters by characterViewModel.characters.observeAsState(emptyList())
    val loading by characterViewModel.isLoading.collectAsState()
    val error by characterViewModel.error.collectAsState()

    Surface {
        if (loading) {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator(color = MaterialTheme.colorScheme.error)
            }
        } else if (error != null) {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text(text = error ?: "Unknown error", color = MaterialTheme.colorScheme.error)
            }
        } else {
                CharacterList(characters = characters)
        }
    }
}
    @Composable
    fun CharacterList(characters: List<Character>) {
        LazyColumn(
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(characters) { character ->
                CharacterCard(character = character)

            }
        }
    }
@Composable
    fun CharacterCard(character: Character) {
        Card(modifier = Modifier.fillMaxSize()) {
            Row (verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(16.dp)) {
//                AsyncImage(
//                    model = character.image,
//                    contentDescription = null,
//                    modifier = Modifier.size(100.dp)
//                )
//                Spacer()
        }
    }
}
