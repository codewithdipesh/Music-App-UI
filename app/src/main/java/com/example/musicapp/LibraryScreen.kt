package com.example.musicapp

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun LibraryScreen() {

    LazyColumn(modifier = Modifier.padding(8.dp) ){
        items(LibraryItems){
            item->
            SingleLibraryItem(item = item)
            Divider()
        }
    }

}



@Composable
fun SingleLibraryItem(item:LibraryItem){
    Row (modifier = Modifier.fillMaxWidth().padding(8.dp),
        horizontalArrangement = Arrangement.SpaceBetween){
        Row() {

            Icon(
                painter = painterResource(item.icon),
                contentDescription = null,
                modifier = Modifier.padding(8.dp)
            )

            Text(text = item.title )



        }
        Icon(
            imageVector = Icons.Default.KeyboardArrowRight,
            contentDescription = null
        )



    }
}







data class LibraryItem(
    val title : String,
    @DrawableRes val icon : Int
)
val LibraryItems = listOf<LibraryItem>(
    LibraryItem("Playlist",R.drawable.baseline_playlist_play_24),
    LibraryItem("Artist",R.drawable.baseline_mic_external_on_24),
    LibraryItem("Album",R.drawable.baseline_album_24),
    LibraryItem("Songs",R.drawable.baseline_music_note_24),
    LibraryItem("Genre",R.drawable.baseline_insights_24),
)