package com.optcatalog.data.repositories

import android.content.Context
import android.content.SharedPreferences
import com.optcatalog.data.local.database.ProductDao
import com.optcatalog.data.model.Product
import com.optcatalog.utils.JsonUtils
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ProductRepository @Inject constructor(private val productDao : ProductDao) {

    fun getAllProduct(): Flow<List<Product>> = productDao.getAllProducts()

    fun searchProduct(productName: String?) : Flow<List<Product>> {
        return productDao.searchProduct(productName)
    }
    suspend fun addProduct(product: Product) {
        productDao.addProduct(product)
    }

    suspend fun addProductList(products : List<Product>){
        productDao.addProductList(products)
    }

    suspend fun getAllProducts() : Flow<List<Product>> {
        return productDao.getAllProducts()
    }

    suspend fun isDatabaseEmpty(): Boolean{
        return productDao.getProductsCount() == 0
    }

    suspend fun insertProductFromJson(context: Context, sharedPreferences: SharedPreferences){
        withContext(Dispatchers.IO){
            if (isDatabaseEmpty() && !sharedPreferences.getBoolean("DATA_IMPORTED", false)) {

                val json = JsonUtils.loadJsonFromAssets(context, "json_product_list.json")
                json?.let {
                    val productList = JsonUtils.parseProductJson(it)
                    productDao.addProductList(productList)

                    sharedPreferences.edit().putBoolean("DATA_IMPORTED", true).apply()
                }
            }
        }
    }

}