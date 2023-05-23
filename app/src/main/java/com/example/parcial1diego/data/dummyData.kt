package com.example.parcial1diego.data

import com.example.parcial1diego.data.model.BookModel

// book one data
val title = "El Sextete-"
val author = "Barkita"
val description = "Conquistando Europa y dominando al mundo"


// movie two data
val title2 = "EL triplete"
val author2 = "Fc Barcelona"
val description2 = "Conquistando again"


var books = mutableListOf(
    BookModel(title, author, description),
    BookModel(title2, author2, description2)    
)