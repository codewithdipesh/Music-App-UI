package com.example.musicapp

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp


val categories = listOf("Hits","Happy","Running","TGIF","Yoga","Workout")
val grouped = listOf<String>("New Relase","Favorites","Top Rated")
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Home(){

    LazyColumn{
     grouped.forEach {item->
         stickyHeader { 
             Text(text = item ,modifier = Modifier.padding(16.dp), fontWeight = FontWeight.Bold)
             LazyRow{
                 items(categories){
                     cat->
                     BrowserItem(cat = cat, drawable = R.drawable.baseline_music_video_24)
                 }
             }
         }
     }    
        
    }
    
}




@Composable
fun BrowserItem(cat:String,drawable:Int){
    Card(modifier = Modifier
        .padding(16.dp)
        .size(200.dp),
        border = BorderStroke(3.dp, Color.DarkGray))
    {
        Column (
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Text(text = cat)
            Image(painter = painterResource(id = drawable), contentDescription = cat)
        }

    }
}

