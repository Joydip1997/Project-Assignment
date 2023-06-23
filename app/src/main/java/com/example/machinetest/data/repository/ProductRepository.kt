package com.example.machinetest.data.repository

import com.example.machinetest.data.model.Product
import kotlinx.coroutines.flow.Flow

interface ProductRepository {
    suspend fun addNewProduct(product: Product)
    fun getProducts() : Flow<List<Product>>
    fun getProductById(productId : Int) : Flow<List<Product>>
}