package com.example.homework4.data

import com.google.gson.annotations.SerializedName

data class NewsResponse(
    @SerializedName("status")
    var status: String?,
    @SerializedName("totalResults")
    var totalResults: Int?,
    @SerializedName("articles")
    var articles: List<ArticleResponse>?,
) {
    data class ArticleResponse(
        @SerializedName("source")
        var source: SourceResponse?,
        @SerializedName("author")
        var author: String?,
        @SerializedName("title")
        var title: String?,
        @SerializedName("description")
        var description: String?,
        @SerializedName("url")
        var url: String?,
        @SerializedName("urlToImage")
        var urlToImage: String?,
        @SerializedName("publishedAt")
        var publishedAt: String?,
        @SerializedName("content")
        var content: String?,
    ) {
        data class SourceResponse(
            @SerializedName("id")
            var id: String?,
            @SerializedName("name")
            var name: String?,
        )
    }
}

fun NewsResponse.ArticleResponse.toUIArticle() = UIArticle(
    sourceName = source?.name ?: "N/A",
    author = author ?: "N/A",
    title = title ?: "N/A",
    imageUrl = urlToImage,
)
