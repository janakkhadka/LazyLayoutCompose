package com.example.jetpackcompose1

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Warning
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Size


@Composable
fun Screen(){
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Image(modifier= Modifier.clip(RoundedCornerShape(20.dp)),
            painter = painterResource(id = R.drawable.a),
            contentDescription = "hello" )

        Spacer(modifier = Modifier
            .height(20.dp))

        val urlImage =
            "https://www.rollingstone.com/wp-content/uploads/2018/06/rs-cristiano-ronaldo-5ebcf9f5-5a0d-4761-ae8c-cce86eaf775e.jpg?w=1401&h=879&crop=1"

        val model = ImageRequest
            .Builder(LocalContext.current)
            .data(urlImage)
            .size(Size.ORIGINAL)
            .build()
        //without handling state
//        AsyncImage(modifier= Modifier.clip(RoundedCornerShape(20.dp)),
//            model = model,
//            contentDescription = null)




        //with handling state

        val imageState = rememberAsyncImagePainter(model = model).state

        Box(modifier = Modifier
            .size(300.dp)
            .clip(RoundedCornerShape(20.dp))
            .background(MaterialTheme.colorScheme.primaryContainer)
        ){
            if(imageState is AsyncImagePainter.State.Success){
                Image(
                    modifier= Modifier
                        .fillMaxSize(),
                    painter = imageState.painter,
                    contentDescription = null,
                    contentScale = ContentScale.Crop)

            }
            if(imageState is AsyncImagePainter.State.Loading){
                CircularProgressIndicator(
                    modifier = Modifier
                        .size(100.dp)
                        .align(Alignment.Center),
                    color = MaterialTheme.colorScheme.primary
                )

            }
            if(imageState is AsyncImagePainter.State.Error){
                Icon(
                    modifier = Modifier
                        .size(100.dp)
                        .align(Alignment.Center),
                    imageVector = Icons.Rounded.Warning, contentDescription = null)

            }


        }




    }

}