package com.example.BookApplication.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.BookApplication.Entity.Book;
import com.example.BookApplication.Repository.BookRepository;

@Service //adding business logic here hence service
public class BookService {
    
    @Autowired   //this is filed injection  on top of filed we are adding injection
    BookRepository bookRepository;   //instance 
    public Book addBook(Book book)
    {
      return bookRepository.save(book);  //this will save book for us .
    }
}
