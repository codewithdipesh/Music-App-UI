package com.example.musicapp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun SubscriptionView(){

    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(8.dp)) {

        Text(text = "Manage Subscription", modifier = Modifier
            .align(Alignment.CenterHorizontally)
            .padding(8.dp))

        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically){
           Column(modifier = Modifier.padding(8.dp)) {
               Text(text = "Musical")
               Text(text = "Free Tier")
           }
           Text(text = "See All plans", color = Color.Magenta)
        }

        Divider(Modifier.padding(4.dp))



    }

}


@Preview(showBackground = true)
@Composable
fun SubscriptionViewPreview(){
    SubscriptionView()
}