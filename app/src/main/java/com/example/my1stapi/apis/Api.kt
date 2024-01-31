package com.example.my1stapi.apis

import com.example.my1stapi.models.MyCart
import com.example.my1stapi.models.ProductModel
import retrofit2.Call
import retrofit2.http.GET

interface Api {
    @GET("products")
    fun getProductData() : Call<ProductModel>




}

