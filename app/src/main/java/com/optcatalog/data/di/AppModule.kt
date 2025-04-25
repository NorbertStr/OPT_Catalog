package com.optcatalog.data.di

import android.content.Context
import androidx.room.Room
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.optcatalog.data.local.database.ProductDao
import com.optcatalog.data.local.database.ProductDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context) : ProductDatabase {
        return Room.databaseBuilder(
            context,
            ProductDatabase::class.java,
            "products_database"
        ).build()
    }

    @Provides
    fun provideNoteDao(database : ProductDatabase) : ProductDao {
        return database.productDao()
    }

    @Provides
    @Singleton
    fun provideFirebaseDatabase(): DatabaseReference {
        val database  = FirebaseDatabase.getInstance(
            "https://opt-catalog-38e5e-default-rtdb.europe-west1.firebasedatabase.app/"
        )
        return database.reference
    }

}