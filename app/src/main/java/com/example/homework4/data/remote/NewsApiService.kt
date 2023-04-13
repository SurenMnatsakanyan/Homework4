package com.example.homework4.data.remote

import com.example.homework4.data.Constants
import com.example.homework4.data.NewsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApiService {
    @GET(Constants.VERSION + "top-headlines?apiKey=" + Constants.API_KEY)
    suspend fun fetchNews(@Query("country") country: String): NewsResponse
}
