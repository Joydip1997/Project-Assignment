package com.example.machinetest.utils

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

fun <T> Flow<T>.collectIn(
    lifecycleOwner: LifecycleOwner,
    onEachValue: (T) -> Unit
) {
    lifecycleOwner.lifecycleScope.launch {
        collect { value ->
            onEachValue(value)
        }
    }
}

fun String.toSafeFloat(): Float {
    return try {
        this.toFloat()
    }catch (e : Exception){
        0f
    }
}