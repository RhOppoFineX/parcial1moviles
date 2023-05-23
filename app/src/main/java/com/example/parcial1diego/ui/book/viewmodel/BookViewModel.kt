package com.example.parcial1diego.ui.book.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory

import com.example.parcial1diego.data.model.BookModel
import com.example.parcial1diego.repositories.BookRepository

class BookViewModel(private val repository: BookRepository): ViewModel() {

    var title = MutableLiveData("")
    var author = MutableLiveData("")
    var description = MutableLiveData("")

    var status = MutableLiveData("")

    fun getBooks() = repository.getBooks()

    fun addBooks(book: BookModel) = repository.addBooks()

    fun createdMovie(){
        if(!validateData()) {
            status.value = WRONG_INFORMATION
            return
        }

        val book = BookModel(
            title.value!!,
            author.value!!,
            description.value!!,
        )

        addBooks(book)
        clearData()


        status.value = MOVIE_CREATE
    }


    private fun validateData(): Boolean{
        when {
            title.value.isNullOrEmpty() -> return false
            author.value.isNullOrEmpty() -> return false
            description.value.isNullOrEmpty() -> return false
        }
        return true
    }

    fun clearData(){
        title.value = ""
        author.value = ""
        description.value = ""
    }

    fun clearStatus(){
        status.value = INACTIVE
    }

    fun setSelectedMovie (book: BookModel) {
        title.value = book.title
        author.value = book.author
        description.value = book.description

    }


    companion object {
        val Factory = viewModelFactory {
            initializer {
                val app = this[APPLICATION_KEY] as BookReviewerApplication
                BookViewModel(app.bookRepository)
            }
        }

        const val MOVIE_CREATE = "Movie created"
        const val WRONG_INFORMATION = "Wrong information"
        const val INACTIVE = ""
    }

}