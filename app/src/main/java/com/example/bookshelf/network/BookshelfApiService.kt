package com.example.bookshelf.network

import com.example.bookshelf.model.BookSearchResults
import retrofit2.Response
import retrofit2.http.GET

interface BookshelfApiService {
    @GET("volumes?q=Jazz+History")
    suspend fun bookSearch(): Response<BookSearchResults>
}