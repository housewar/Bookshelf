package com.example.bookshelf.model

data class BookSearchResults(
    val kind: String = "books#volumes",
    val totalItems: Int = 0,
    val items: List<Book> = listOf<Book>()
)
