package com.optcatalog.data.local.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.optcatalog.data.model.Product
import kotlinx.coroutines.flow.Flow

@Dao
interface ProductDao {
    @Query("SELECT * FROM products_database")
    fun getAllProducts(): Flow<List<Product>>

    @Query("SELECT * FROM products_database WHERE :query IS NULL OR number LIKE '%' || :query || '%'" )
    fun searchProduct(query: String?) : Flow<List<Product>>

    @Insert
    suspend fun addProduct(product: Product)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addProductList(products : List<Product>)

    @Query("SELECT COUNT (*) FROM products_database")
    suspend fun getProductsCount(): Int

    @Query("DELETE FROM products_database")
    suspend fun deleteAllProducts()
}