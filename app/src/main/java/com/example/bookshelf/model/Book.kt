package com.example.bookshelf.model

data class Book(
    val id: String,
    val kind: String,
    val volumeInfo: VolumeInfo
)