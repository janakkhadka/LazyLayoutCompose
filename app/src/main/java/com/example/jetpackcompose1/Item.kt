package com.example.jetpackcompose1

import androidx.annotation.DrawableRes

data class Item(
    val title: String,
    @DrawableRes val image: Int
)
