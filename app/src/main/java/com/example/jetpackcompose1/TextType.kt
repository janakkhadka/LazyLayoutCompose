package com.example.jetpackcompose1

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable
fun TextTypes(){

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        var textInput by remember {
            mutableStateOf("")
        }

        BasicTextField(
            value = textInput,
            onValueChange = {
                textInput = it
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
                .clip(RoundedCornerShape(10.dp))
                .border(2.dp, Color.Black)
                .background(MaterialTheme.colorScheme.primaryContainer)
                .padding(16.dp),
            decorationBox = {innerTextField ->
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ){

                    Icon(imageVector = Icons.Default.Search,
                        contentDescription = "search")

                    Spacer(modifier = Modifier.width(8.dp))

                    Box(modifier = Modifier.weight(1f)){

                        if(textInput.isEmpty()){
                            Text(text = "Search",
                                color = MaterialTheme.colorScheme.background)
                        }
                        innerTextField()
                    }

                    Spacer(modifier = Modifier.width(8.dp))

                    Icon(imageVector = Icons.Default.Clear,
                        contentDescription = "clear",
                        Modifier
                            .clickable {
                                textInput = ""
                            })

                }
            }

        )

        Spacer(modifier = Modifier.height(25.dp))

        OutlinedTextField(value = textInput, onValueChange = {
            textInput = it
        } )

    }

}