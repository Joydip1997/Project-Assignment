package com.example.machinetest.data.repository

import com.example.machinetest.data.model.Product
import com.example.machinetest.db.MyAppDataBase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class ProductRepositoryImpl @Inject constructor(private val db : MyAppDataBase) : ProductRepository {
    override suspend fun addNewProduct(product: Product) {
        db.productDao().addProduct(product)
    }

    override fun getProducts() = db.productDao().getProducts()

    override fun getProductById(productId: Int)  = db.productDao().getProductById(productId = productId)
}