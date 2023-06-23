package com.example.machinetest.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.machinetest.data.model.Product

@Database(
    entities = [
        Product::class
    ],
    version = 1,
    exportSchema = false
)
@TypeConverters(ProductTypeConverter::class)
abstract class MyAppDataBase : RoomDatabase() {
    abstract fun productDao() : ProductDao
}