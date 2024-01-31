package com.example.my1stapi.adapter

import com.example.my1stapi.Product
import android.annotation.SuppressLint
import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.my1stapi.R
import com.squareup.picasso.Picasso

class ProductAdapter(val context: Activity, val productArrayList: List<com.example.my1stapi.Product>) :
    RecyclerView.Adapter<ProductAdapter.MyViewHolder>() {

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var title: TextView
        var rating: RatingBar
        var image: ImageView
        var stock: TextView
        var discountPercentage: TextView
        var price: TextView
        var brand: TextView

        init {
            title = itemView.findViewById(R.id.productTitle)
            image = itemView.findViewById(R.id.ProductImage)
            rating = itemView.findViewById(R.id.rating)
            stock = itemView.findViewById(R.id.productStock)
            discountPercentage = itemView.findViewById(R.id.DiscountPercentage)
            price = itemView.findViewById(R.id.ProductPrice)
            brand= itemView.findViewById(R.id.productBrand)


        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val itemView = LayoutInflater.from(context).inflate(R.layout.eachitem, parent, false)
        return MyViewHolder(itemView)

    }

    override fun getItemCount(): Int {
        return productArrayList.size
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val currentItem = productArrayList[position]
        holder.title.text = "title:  "+ currentItem.title
        holder.rating.rating= currentItem.rating.toFloat()
        holder.stock.text=  "stock:  "+ currentItem.stock.toString()
        holder.brand.text= "brand:  "+ currentItem.brand
        holder.discountPercentage.text = "discountPercentage:  "+ currentItem.discountPercentage.toString()
        holder.price.text ="Price:  "+ currentItem.price.toString()

        //image view, hoe to show image in imageview if the image is in the form of url,
        // 3rd party library
        //picasso
        Picasso.get().load(currentItem.thumbnail).into(holder.image);


    }
}