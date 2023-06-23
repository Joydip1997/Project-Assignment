package com.example.machinetest.db

import androidx.room.TypeConverter
import com.example.machinetest.data.model.Product
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ProductTypeConverter {

    @TypeConverter
    fun fromProduct(product: Product) : String = Gson().toJson(product)

    @TypeConverter
    fun toProduct(json : String) : Product{
        val gson = Gson()
        val type = object : TypeToken<Product>() {}.type
        return gson.fromJson(json, type)
    }

    @TypeConverter
    fun fromProductList(productList: ArrayList<Product>) : String = Gson().toJson(productList)

    @TypeConverter
    fun toProductList(json : String) : ArrayList<Product>{
        val gson = Gson()
        val type = object : TypeToken<ArrayList<Product>>() {}.type
        return gson.fromJson(json, type)
    }

    @TypeConverter
    fun fromProductImages(productImages: ArrayList<Int>) : String = Gson().toJson(productImages)

    @TypeConverter
    fun toProductImages(json : String) : ArrayList<Int>{
        val gson = Gson()
        val type = object : TypeToken<ArrayList<Int>>() {}.type
        return gson.fromJson(json, type)
    }
}