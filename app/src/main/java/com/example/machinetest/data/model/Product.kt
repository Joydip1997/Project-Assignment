package com.example.machinetest.data.model

import android.os.Parcelable
import com.example.machinetest.R
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Product(
    val id : String,
    val productImages : ArrayList<Int>,
    val productTitle : String,
    val productDescription : String,
    val productPrice : Float
) : Parcelable

val productList = arrayListOf(
    Product(
        id = "1",
        productImages = arrayListOf(R.drawable.ic_item_1,R.drawable.ic_item_1,R.drawable.ic_item_1),
        productTitle = "Product 1",
        productDescription = "Products 1",
        productPrice = 9.99f
    ),
    Product(
        id = "2",
        productImages = arrayListOf(R.drawable.ic_item_2,R.drawable.ic_item_2,R.drawable.ic_item_2),
        productTitle = "Product 2",
        productDescription = "Products 2",
        productPrice = 19.99f
    ),
    Product(
        id = "3",
        productImages = arrayListOf(R.drawable.ic_item_3,R.drawable.ic_item_3,R.drawable.ic_item_3),
        productTitle = "Product 3",
        productDescription = "Products 3",
        productPrice = 14.99f
    ),
    Product(
        id = "4",
        productImages = arrayListOf(R.drawable.ic_item_4,R.drawable.ic_item_4,R.drawable.ic_item_4),
        productTitle = "Product 10",
        productDescription = "Products 4",
        productPrice = 29.99f
    )
)