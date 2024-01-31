package com.example.my1stapi.adapter

import android.annotation.SuppressLint
import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.my1stapi.R
import com.example.my1stapi.models.Cart
import com.example.my1stapi.models.MyCart
import com.squareup.picasso.Picasso

class CartAdapter (val context: Activity, val cartArrayList: List<Cart>)  :
RecyclerView.Adapter<CartAdapter.MyViewHolder>(){

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

         var image: ImageView
         var title: TextView
         var price: TextView
         var quantity: TextView
         var total: TextView
         var discountPercentage: TextView
         var discountPrice: TextView

        init {

            image= itemView.findViewById(R.id.cartImage)
            title = itemView.findViewById(R.id.cartTitle)
            price = itemView.findViewById(R.id.cartPrice)
            quantity = itemView.findViewById(R.id.CartQuantity)
            total = itemView.findViewById(R.id.cartTotal)
            discountPercentage = itemView.findViewById(R.id.cartDiscountPercentage)
            discountPrice = itemView.findViewById(R.id.cartDiscountPrice)



        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {


        val itemView = LayoutInflater.from(context).inflate(R.layout.cartitem,parent,false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return cartArrayList.size

    }
    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val currentItem = cartArrayList[position]
        holder.title.text = "title: "+ currentItem.discountedTotal.toString()
        holder.price.text = "price: "+ currentItem.id.toString()
        holder.quantity.text ="quantity: "+ currentItem.products.toString()
        holder.quantity.text ="quantity: "+ currentItem.total.toString()
        holder.total.text ="total: "+ currentItem.totalProducts.toString()
        holder.discountPercentage.text ="discountPercentage: "+ currentItem.totalQuantity.toString()
        holder.discountPrice.text ="discountPrice: "+ currentItem.userId.toString()


        Picasso.get().load(currentItem.products.get(0).thumbnail).into(holder.image)


    }

}
