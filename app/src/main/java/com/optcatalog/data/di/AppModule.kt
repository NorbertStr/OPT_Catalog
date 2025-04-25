package com.optcatalog.data.di

import android.content.Context
import androidx.room.Room
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.optcatalog.data.local.database.ProductDao
import com.optcatalog.data.local.database.ProductDatabase
import com.optcatalog.data.repositories.FirebaseUrlAddress
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
            FirebaseUrlAddress.getUrl()
        )
        return database.reference
    }

    @Provides
    @Singleton
    fun provideFirebaseAnalytics(@ApplicationContext context: Context): FirebaseAnalytics{
        return FirebaseAnalytics.getInstance(context)
    }

}