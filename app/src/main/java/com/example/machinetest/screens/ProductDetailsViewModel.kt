package com.example.machinetest.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.machinetest.data.model.Product
import com.example.machinetest.data.repository.ProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class ProductDetailsViewModel @Inject constructor(private val productRepository: ProductRepository) : ViewModel() {

    private val _productDetails : MutableStateFlow<Product?> = MutableStateFlow(null)
    val productDetails : StateFlow<Product?> = _productDetails.asStateFlow()



    fun getProductDetailsById(productId : Int){
        productRepository.getProductById(productId).onEach { products->
            _productDetails.emit(ArrayList(products).first())
        }.launchIn(viewModelScope)
    }
}