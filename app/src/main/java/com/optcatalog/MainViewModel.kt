package com.optcatalog

import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.optcatalog.data.model.Product
import com.optcatalog.data.repositories.FirebaseRepository
import com.optcatalog.data.repositories.ProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: ProductRepository,
    private val firebaseRepository: FirebaseRepository
) : ViewModel() {

    private val _searchResults = MutableStateFlow<List<Product>>(emptyList())
    val products: StateFlow<List<Product>> = _searchResults.asStateFlow()

//    val products = repository.getAllProduct()
//        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(), emptyList())
//    private val _firebaseProducts = MutableStateFlow<List<Product>>(emptyList())
//    val firebaseProducts: StateFlow<List<Product>> = _firebaseProducts.asStateFlow()
//
//    fun loadProductsFromFirebase() {
//        viewModelScope.launch {
//            _firebaseProducts.value = firebaseRepository.getAllProductsFromFirebase()
//        }
//    }

    private var _downloadProductsFromFirebaseIsSuccess = MutableStateFlow(false)
    val downloadProductsFromFirebaseIsSuccess = _downloadProductsFromFirebaseIsSuccess.asStateFlow()

    fun updateLocalDatabaseFromFirebase() {
        viewModelScope.launch {
            var firebaseProducts =
                firebaseRepository.getAllProductsFromFirebase()

            if (firebaseProducts.isNotEmpty() && firebaseProducts.size >= 108) {
                withContext(Dispatchers.IO) {
                    deleteAllProducts()
                    addProductsList(firebaseProducts)

                }
                _downloadProductsFromFirebaseIsSuccess.value = true
            }else {
                _downloadProductsFromFirebaseIsSuccess.value = false
            }
            Log.d("firebaseProductsSize", "${firebaseProducts.isNotEmpty()}")
            Log.d("downloadProductsFromFirebaseIsSuccess","${_downloadProductsFromFirebaseIsSuccess.value}")
        }

    }

    fun deleteAllProducts() {
        viewModelScope.launch {
            repository.deleteAllProducts()
        }
    }

    fun searchProduct(product: String) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                repository.searchProduct(if (product.isBlank()) null else product)
                    .collect { products ->
                        _searchResults.value = products
                    }
            }
        }
    }

    fun addProduct(product: Product) {
        viewModelScope.launch {
            repository.addProduct(product)
        }
    }

    fun addProductsList(products: List<Product>) {
        viewModelScope.launch {
            repository.addProductList(products)
        }
    }


    fun initializeDatabase(context: Context) {

        val sharedPreferences = context.getSharedPreferences("app_prefs", Context.MODE_PRIVATE)

        viewModelScope.launch {
            repository.insertProductFromJson(context, sharedPreferences)
        }
    }
}