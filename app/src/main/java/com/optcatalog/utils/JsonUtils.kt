package com.optcatalog.utils

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.optcatalog.data.model.Product
import java.io.IOException
import java.io.InputStream

object JsonUtils {

    fun loadJsonFromAssets(context: Context, fileName: String): String? {
        return try {
            val inputStream: InputStream = context.assets.open(fileName)
            val size: Int = inputStream.available()
            val buffer = ByteArray(size)
            inputStream.read(buffer)
            inputStream.close()
            String(buffer, Charsets.UTF_8)
        } catch (ex: IOException) {
            ex.printStackTrace()
            null
        }
    }

    fun parseProductJson(json: String): List<Product> {
        val gson = Gson()
        val type = object : TypeToken<List<Product>>() {}.type
        return gson.fromJson(json, type)
    }
}