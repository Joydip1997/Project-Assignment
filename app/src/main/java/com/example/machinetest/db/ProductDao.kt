package com.example.machinetest.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.machinetest.data.model.Product
import kotlinx.coroutines.flow.Flow

@Dao
interface ProductDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addProduct(product : Product)

    @Query("SELECT * FROM ProductTable")
    fun getProducts() : Flow<List<Product>>

    @Query("SELECT * FROM ProductTable WHERE id = :productId")
    fun getProductById(productId: Int): Flow<List<Product>>
}