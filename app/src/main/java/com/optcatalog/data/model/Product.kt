package com.optcatalog.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "products_database")
data class Product(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val number: String = "",
    val name: String = "",
    val serial: String = "",
    val lot: String = "",
    val description: String = ""
)