package com.optcatalog

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.optcatalog.data.model.Product
import com.optcatalog.data.repositories.ProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: ProductRepository
) : ViewModel(){

//    val products = repository.getAllProduct()
//        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(), emptyList())

    private val _searchResults = MutableStateFlow<List<Product>>(emptyList())
    val products: StateFlow<List<Product>> = _searchResults.asStateFlow()

    fun searchProduct(product: String) {
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                repository.searchProduct(if(product.isBlank()) null else product)
                    .collect{products ->
                        _searchResults.value = products
                    }
            }
        }
    }

    fun addProduct(product: Product){
        viewModelScope.launch {
            repository.addProduct(product)
        }
    }

    fun addProductsList(products: List<Product>){
        viewModelScope.launch {
            repository.addProductList(products)
        }
    }


    fun initializeDatabase(context: Context){

        val sharedPreferences = context.getSharedPreferences("app_prefs", Context.MODE_PRIVATE)

        viewModelScope.launch {
            repository.insertProductFromJson(context, sharedPreferences)
        }
    }
}