package com.example.bookshelf.model

data class VolumeInfo(
    val authors: List<String>,
    val contentVersion: String?,
    val description: String?,
    val imageLinks: ImageLinks,
    val language: String?,
    val subtitle: String?,
    val title: String?
)