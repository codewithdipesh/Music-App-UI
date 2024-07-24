package com.example.musicapp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.DialogProperties

@Composable

fun AccountDialog(isEnabled : MutableState<Boolean>){

    if(isEnabled.value){

        AlertDialog(
            onDismissRequest = {
                               isEnabled.value = false
            },
            confirmButton = {
                TextButton(onClick = {
                    isEnabled.value = false
                }) {
                    Text(text = "Confirm")
                }
            },
            dismissButton = {
                TextButton(onClick = {
                    isEnabled.value = false
                }) {
                    Text(text = "Dismiss")
                }

            },
            title = {
                Text(text = "Add Account")
            },
            text = {
                Column(modifier = Modifier
                    .wrapContentHeight()
                    .padding(16.dp))
                    {

                        TextField(
                            value = "",
                            onValueChange = {

                            },
                            label = { Text(text = "Email")},
                            modifier = Modifier.padding(top = 16.dp)

                        )

                        TextField(
                            value = "",
                            onValueChange = {

                            },
                            label = { Text(text = "Password")},
                            modifier = Modifier.padding(top = 8.dp)

                        )


                    }
            },
            modifier = Modifier.fillMaxWidth().background(MaterialTheme.colorScheme.primaryContainer),
            shape = RoundedCornerShape(5.dp),
            properties = DialogProperties(
                dismissOnBackPress = true,
                dismissOnClickOutside = true
            )

        )
    }

}