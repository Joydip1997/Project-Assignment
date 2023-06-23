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
class ProductListViewModel @Inject constructor(private val productRepository: ProductRepository) : ViewModel() {

    private val _productList : MutableStateFlow<ArrayList<Product>> = MutableStateFlow(ArrayList())
    val productList : StateFlow<ArrayList<Product>> = _productList.asStateFlow()



    fun fetchProducts(){
        productRepository.getProducts().onEach { products->
            _productList.emit(ArrayList(products))
        }.launchIn(viewModelScope)
    }
}