package com.example.jetpackcompose1

import android.widget.MediaController
import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController


@Composable
fun HomeScreen(
    navHostController : NavHostController
){
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){

        Button(onClick = { navHostController.navigate("lazy_column_screen")}) {
            Text(text = "LazyColumn")
        }

        Spacer(modifier = Modifier.height(30.dp))

        Button(onClick = { navHostController.navigate("lazy_row_screen") }) {
            Text(text = "LazyRow")
        }

        Spacer(modifier = Modifier.height(30.dp))

        Button(onClick = { navHostController.navigate("lazy_grid_screen") }) {
            Text(text = "LazyGrid")
        }

    }

}
@Composable
fun LazyRowScreen(){
    LazyRow (
        modifier = Modifier
            .fillMaxSize()
            .padding(top=50.dp),
        contentPadding = PaddingValues(16.dp),
    ){

        itemsIndexed(CompanionClass.items){index, item ->
            Spacer(modifier = Modifier.width(8.dp))
            
            Column(
                modifier = Modifier
                    .height(350.dp)
                    .width(200.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(300.dp)
                        .clip(RoundedCornerShape(30.dp)),
                    painter = painterResource(id = item.image),
                    contentDescription = item.title,
                    contentScale = ContentScale.Crop
                    )

                Spacer(modifier = Modifier.height(8.dp))

                Text(text = item.title, fontWeight= FontWeight.SemiBold)

            }



        }

    }

}
@Composable
fun LazyColumnScreen(){
    LazyColumn (
        modifier = Modifier
            .fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
    ){
        itemsIndexed(CompanionClass.items){index, item ->

            Column(
                modifier = Modifier
                    .height(250.dp)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    modifier = Modifier
                        .height(200.dp)
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(30.dp)),
                    painter = painterResource(id = item.image),
                    contentDescription = item.title,
                    contentScale = ContentScale.Crop
                )

            }
            Spacer(modifier = Modifier.height(8.dp))

        }

    }

}
@Composable
fun LazyGridScreen(){
    LazyVerticalGrid (
        modifier = Modifier
            .fillMaxSize(),
        contentPadding = PaddingValues(vertical = 16.dp),
        columns = GridCells.Fixed(2)
    ){

        itemsIndexed(CompanionClass.items){index, item ->

            Column(
                modifier = Modifier
                    .height(250.dp)
                    .width(200.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    modifier = Modifier
                        .size(200.dp)
                        .clip(RoundedCornerShape(30.dp)),
                    painter = painterResource(id = item.image),
                    contentDescription = item.title,
                    contentScale = ContentScale.Crop
                )

            }
            Spacer(modifier = Modifier.width(8.dp))

        }

    }

}



