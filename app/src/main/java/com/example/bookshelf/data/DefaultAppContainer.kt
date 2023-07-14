package com.example.bookshelf.data

import com.example.bookshelf.network.BookshelfApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * The URL we are searching
 * */
private const val BASE_URL =
    "https://www.googleapis.com/books/v1/"

class DefaultAppContainer : AppContainer {

    /*
    * Use the Retrofit builder to build a retrofit object using Gson implementation
    * */
    private val retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .build()

    /*
    * Provide retrofit with our interface function names and return types
    * */
    private val retrofitService: BookshelfApiService by lazy {
        retrofit.create(BookshelfApiService::class.java)
    }

    /**
     * Inject our finished retrofit service into our repository
     */
    override val bookSearchRepository: BookSearchRepository by lazy {
        NetworkBookSearchRepository(retrofitService)
    }
}