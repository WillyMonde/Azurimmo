package com.example.azurimmo.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.google.gson.GsonBuilder
import com.google.gson.JsonDeserializer
import java.time.LocalDate
import java.time.format.DateTimeFormatter

object RetrofitInstance {

    val localDateAdapter: JsonDeserializer<LocalDate> = JsonDeserializer { json, _, _ ->
        LocalDate.parse(json.asString, DateTimeFormatter.ISO_DATE)
    }

    val gson = GsonBuilder()
        .registerTypeAdapter(LocalDate::class.java, localDateAdapter)
        .create()

    //private const val BASE_URL = "http://10.0.2.2:9006/"
    private const val BASE_URL = "http://172.20.177.251:8080/willyazurimmo/"
    val api: ApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(ApiService::class.java)
    }
}