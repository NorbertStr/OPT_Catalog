package com.optcatalog.data.repositories

import android.util.Log
import com.google.firebase.database.DatabaseReference
import com.optcatalog.data.model.Product
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class FirebaseRepository @Inject constructor(private val firebaseDatabase: DatabaseReference) {

    suspend fun getAllProductsFromFirebase(): List<Product> {
        return  try {
            val snapshot = firebaseDatabase.child("Products").get().await()
            snapshot.children.mapNotNull { it.getValue(Product::class.java) }
        }catch (e: Exception){
            Log.e("Firebase", "Błąd podczas pobierania produktów: ${e.message}")
            emptyList()
        }
        }
}