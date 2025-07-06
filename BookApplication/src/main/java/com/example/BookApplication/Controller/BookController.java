package com.example.BookApplication.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.BookApplication.Entity.Book;
import com.example.BookApplication.Services.BookService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController //responseebody +controller annotation
@RequestMapping("/books")
public class BookController {

   @Autowired //inject bookservice dependency in controller class .i.e dependency injection
    private  BookService bookservice;
    
     public BookController(BookService bookservice) {
        this.bookservice = bookservice;
    }

    @GetMapping
    public List<Book>getAllBooks(){
      return bookservice.getAllBooks();
    }

    @GetMapping("/{id}")
    public Book getBookbyId(@PathVariable Integer id)
    {
      return bookservice.getBookbyId(id);
    }
     //api to add book to our database
     @PostMapping("/addBook") //request body as passing json to application which will be converted to entity 
     public Book addBook(@RequestBody Book book)
     {
          
            return  bookservice.addBook(book);
     }

     @PutMapping("/{id}")
     public Book updateBook(@PathVariable Integer id, @RequestBody Book book){
      return bookservice.updateBook(id, book);
     }
     
     @DeleteMapping("{/id}")
     public String deleteBook(@PathVariable Integer id){
    boolean removed =bookservice.deleteBook(id);
    return removed ? "book is deleted " : "book not found ";
     }

}
