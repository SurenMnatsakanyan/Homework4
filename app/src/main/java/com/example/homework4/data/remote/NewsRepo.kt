package com.example.homework4.data.remote

class NewsRepo(
    private val apiService: NewsApiService = RetrofitHelper.getInstance()
        .create(NewsApiService::class.java),
) {
    suspend fun fetchNews(country: String) = apiService.fetchNews(country)
}
