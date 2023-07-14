package com.example.bookshelf.data

import com.example.bookshelf.model.BookSearchResults
import com.example.bookshelf.network.BookshelfApiService
import retrofit2.Response

class NetworkBookSearchRepository (
    private val bookshelfApiService: BookshelfApiService
    ) : BookSearchRepository {
    override suspend fun bookSearch(): BookSearchResults {
        val response = bookshelfApiService.bookSearch()
        val bookSearchResults = if (response.isSuccessful && response.body() != null ){
            response.body()!!
        } else {
            BookSearchResults()
        }
        return bookSearchResults
    }
}