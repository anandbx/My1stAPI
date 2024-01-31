package com.example.my1stapi.models

data class MyCart(
    val carts: List<Cart>,
    val limit: Int,
    val skip: Int,
    val total: Int
)