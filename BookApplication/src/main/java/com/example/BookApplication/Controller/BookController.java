package com.example.BookApplication.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.BookApplication.Entity.Book;
import com.example.BookApplication.Services.BookService;

@RestController //responseebody +controller annotation
@RequestMapping("/book/v1")
public class BookController {

    private final BookService bookservice;
    
    //this is constructor injection using autowired
     @Autowired //inject bookservice dependency in controller class .i.e dependency injection
     public BookController(BookService bookservice) {
        this.bookservice = bookservice;
    }


     //api to add book to our database
     @PostMapping("/addBook") //request body as passing json to application which will be converted to entity 
     public ResponseEntity<Book> addBook(@RequestBody Book book)
     {
          Book savedBook = bookservice.addBook(book);  // this function add book inside datbase.
            return  ResponseEntity.ok(savedBook);
     }
}
