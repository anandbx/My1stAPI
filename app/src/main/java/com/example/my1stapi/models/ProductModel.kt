package com.example.my1stapi.models

import com.example.my1stapi.Product

class ProductModel(
    val limit: Int,
    val products: List<com.example.my1stapi.Product>,
    val skip: Int,
    val total: Int,
)