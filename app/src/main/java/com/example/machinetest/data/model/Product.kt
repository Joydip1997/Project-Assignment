package com.example.machinetest.data.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.machinetest.R
import kotlinx.android.parcel.Parcelize


@Entity(tableName = "ProductTable")
data class Product(
    @PrimaryKey(autoGenerate = true)
    val id : Int = 0,
    val productImages : ArrayList<Int> = ArrayList(),
    val productTitle : String,
    val productDescription : String,
    val productManufacturer : String,
    val productPartModel : String,
    val productPartNumber : String,
    val productPrice : Float
){
    fun hasProperData(): Boolean {
        return productImages.isNotEmpty() &&
                productTitle.isNotBlank() &&
                productDescription.isNotBlank() &&
                productManufacturer.isNotBlank() &&
                productPartModel.isNotBlank() &&
                productPartNumber.isNotBlank() &&
                productPrice > 0f
    }
}

val productImageList = arrayListOf(
    arrayListOf(R.drawable.ic_item_1,R.drawable.ic_item_1,R.drawable.ic_item_1,R.drawable.ic_item_1),
    arrayListOf(R.drawable.ic_item_2,R.drawable.ic_item_2,R.drawable.ic_item_2,R.drawable.ic_item_2),
    arrayListOf(R.drawable.ic_item_3,R.drawable.ic_item_3,R.drawable.ic_item_3,R.drawable.ic_item_3),
    arrayListOf(R.drawable.ic_item_4,R.drawable.ic_item_4,R.drawable.ic_item_4,R.drawable.ic_item_4)
)