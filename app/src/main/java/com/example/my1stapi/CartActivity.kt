package com.example.my1stapi

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.my1stapi.adapter.CartAdapter
import com.example.my1stapi.apis.CartInterface
import com.example.my1stapi.models.MyCart
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class CartActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    lateinit var cartAdapter: CartAdapter

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)

        recyclerView = findViewById(R.id.recyclerView1)


        val retrofitBuilder = Retrofit.Builder()
            .baseUrl("https://dummyjson.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CartInterface::class.java)

        val retrofitData = retrofitBuilder.getProductData()

        retrofitData.enqueue(object : Callback<MyCart?> {
            override fun onResponse(call: Call<MyCart?>, response: Response<MyCart?>) {

                var responseBody = response.body()
                val productList = responseBody?.carts!!

                cartAdapter = CartAdapter(this@CartActivity, productList)
                recyclerView.adapter = cartAdapter
                recyclerView.layoutManager = LinearLayoutManager(this@CartActivity)

            }

            override fun onFailure(call: Call<MyCart?>, t: Throwable) {
                Log.d("Cart Activity ", "onFailure: " + t.message)
            }
        })
    }
}