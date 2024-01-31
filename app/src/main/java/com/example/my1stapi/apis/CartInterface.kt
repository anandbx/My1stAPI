package com.example.my1stapi.apis

import com.example.my1stapi.models.MyCart
import retrofit2.Call
import retrofit2.http.GET

interface CartInterface {
    @GET("carts")
    fun getProductData(): Call<MyCart>
}