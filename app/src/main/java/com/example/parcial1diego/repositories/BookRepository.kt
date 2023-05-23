package com.example.parcial1diego.repositories

import com.example.parcial1diego.data.model.BookModel

class BookRepository(private val books: MutableList<BookModel>) {

    fun getBooks() = books

    fun addBooks(book: BookModel) = books.add(book)
}