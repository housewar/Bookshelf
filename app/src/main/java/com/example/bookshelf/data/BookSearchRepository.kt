package com.example.bookshelf.data

import com.example.bookshelf.model.BookSearchResults
import retrofit2.Response

interface BookSearchRepository {
    suspend fun bookSearch() : BookSearchResults
}