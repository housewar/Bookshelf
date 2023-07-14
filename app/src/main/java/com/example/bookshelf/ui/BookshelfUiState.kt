package com.example.bookshelf.ui

import com.example.bookshelf.model.BookSearchResults

sealed interface BookshelfUiState {
    data class Success(val bookSearchResults: BookSearchResults) : BookshelfUiState
    object Error : BookshelfUiState
    object Loading : BookshelfUiState
}