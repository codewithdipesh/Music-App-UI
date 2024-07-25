package com.example.musicapp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun AccountView(){

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
    ) {

        Row (modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween){
            Row() {

                Icon(
                    imageVector = Icons.Default.AccountCircle,
                    contentDescription = null,
                    modifier = Modifier.padding(8.dp)
                )
                Column {
                    Text(text = "Dipesh Pal")
                    Text(text = "@codewithdipesh2022")
                }

            }
            Icon(
                imageVector = Icons.Default.KeyboardArrowRight,
                contentDescription = null
            )



        }

        Row (modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)){
            Icon(painter = painterResource(id = R.drawable.baseline_queue_music_24), contentDescription = null)
            Text(text = "My Music")

        }

        Divider(modifier = Modifier.padding(horizontal = 8.dp))


    }

}




@Preview(showBackground = true)
@Composable

fun AccountViewPreview(){
    AccountView()
}