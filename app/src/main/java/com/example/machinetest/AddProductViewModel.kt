package com.example.machinetest

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.machinetest.data.model.Product
import com.example.machinetest.data.repository.ProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddProductViewModel @Inject constructor(private val productRepository: ProductRepository) : ViewModel() {

    private val _isProductAdded : MutableSharedFlow<Boolean> = MutableSharedFlow()
    val isProductAdded : SharedFlow<Boolean> = _isProductAdded.asSharedFlow()


    fun addNewProduct(product: Product){
        viewModelScope.launch {
            if(!product.hasProperData()){
                _isProductAdded.emit(false)
            }else{
                productRepository.addNewProduct(product=product)
                _isProductAdded.emit(true)
            }

        }
    }
}