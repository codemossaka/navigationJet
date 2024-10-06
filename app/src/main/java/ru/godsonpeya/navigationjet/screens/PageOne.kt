package ru.godsonpeya.navigationjet.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import ru.godsonpeya.navigationjet.database.data
import ru.godsonpeya.navigationjet.database.entity.SongEntity
import ru.godsonpeya.navigationjet.navigation.AppNavigation

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PageOne(navController: NavController) {

    val songs = data.collectAsState()
    Scaffold(topBar = {
        TopAppBar(title = {
            Text(text = "Page One")
        })
    }) { padding ->
        LazyColumn(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            items(songs.value) { song ->
                SongItem(song) {
                    navController.navigate(AppNavigation.PAGE_TWO + "/${song.id}")
                }
            }
        }
    }
}


@Composable
fun SongItem(song: SongEntity, onSongClick: () -> Unit) {
    Card(
        elevation = CardDefaults.cardElevation(4.dp),
        modifier = Modifier
            .clickable { onSongClick.invoke() }
            .padding(8.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(song.id.toString())
            Text(text = song.title, modifier = Modifier.padding(start = 8.dp))
        }
    }
}