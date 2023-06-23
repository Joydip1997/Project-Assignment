package com.example.machinetest.data.model

import com.example.machinetest.R

data class Product(
    val id : String,
    val productImage : Int,
    val productTitle : String,
    val productDescription : String,
    val productPrice : Float
)

val productList = arrayListOf(
    Product(
        id = "1",
        productImage = R.drawable.ic_item_1,
        productTitle = "Product 1",
        productDescription = "Products 1",
        productPrice = 9.99f
    ),
    Product(
        id = "2",
        productImage = R.drawable.ic_item_2,
        productTitle = "Product 2",
        productDescription = "Products 2",
        productPrice = 19.99f
    ),
    Product(
        id = "3",
        productImage = R.drawable.ic_item_3,
        productTitle = "Product 3",
        productDescription = "Products 3",
        productPrice = 14.99f
    ),
    Product(
        id = "4",
        productImage = R.drawable.ic_item_4,
        productTitle = "Product 10",
        productDescription = "Products 4",
        productPrice = 29.99f
    )
)