package com.example.my1stapi

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.my1stapi.adapter.ProductAdapter
import com.example.my1stapi.apis.Api
import com.example.my1stapi.models.ProductModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : ComponentActivity() {

    lateinit var recyclerView: RecyclerView
    lateinit var productAdapter: ProductAdapter


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
      setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        val retrofitBuilder = Retrofit.Builder()
            .baseUrl("https://dummyjson.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(Api::class.java)

        val retrofitData = retrofitBuilder.getProductData()

        retrofitData.enqueue(object :Callback<ProductModel?>{
            override fun onResponse(call: Call<ProductModel?>, response: Response<ProductModel?>) {


                var responseBody = response.body()
                val productList = responseBody?.products!!

                productAdapter = ProductAdapter(this@MainActivity,productList)
                recyclerView.adapter = productAdapter
                recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
            }

            override fun onFailure(call: Call<ProductModel?>, t: Throwable) {

                Log.d("Main Activity ", "onFailure: " + t.message)
            }

        })

    }


}
