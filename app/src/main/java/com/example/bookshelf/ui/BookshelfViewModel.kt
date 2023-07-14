package com.example.bookshelf.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.bookshelf.BookshelfApplication
import com.example.bookshelf.data.BookSearchRepository
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

class BookshelfViewModel(private val bookSearchRepository: BookSearchRepository): ViewModel() {
    var bookshelfUiState: BookshelfUiState by mutableStateOf(BookshelfUiState.Loading)
        private set

    init {
        bookSearch()
    }

    fun bookSearch() {
        viewModelScope.launch {
            bookshelfUiState = try {
                // Get the Http response
                val results = bookSearchRepository.bookSearch()
                // If the response was successful and contains results, update the state
                if (results.totalItems > 0) {
                    BookshelfUiState.Success(results)
                } else {
                    // if the response wasn't successful, or doesn't contain results, set the state to an error
                    BookshelfUiState.Error
                }
            } catch (e: IOException) {
                BookshelfUiState.Error
            } catch (e: HttpException) {
                BookshelfUiState.Error
            }
        }
    }
    /*
    * Creates a ViewModel that takes a BookSearchRepository dependency
    * */
    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as BookshelfApplication)
                val bookSearchRepository = application.container.bookSearchRepository
                BookshelfViewModel(bookSearchRepository = bookSearchRepository)
            }
        }
    }
}