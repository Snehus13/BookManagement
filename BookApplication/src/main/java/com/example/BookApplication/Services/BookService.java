package com.example.BookApplication.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.BookApplication.Entity.Book;

@Service //adding business logic here hence service
public class BookService {
    
    private List<Book>books =new ArrayList<>();
    private Integer idcounter=1;

    public List<Book>getAllBooks(){
      return books;
    }
    public Book getBookbyId(Integer id){
      return books.stream().filter(b->b.getId().equals(id)).findFirst().orElse(null);
    } 

    public Book addBook(Book book){
      book.setId(idcounter++);
      books.add(book);
      return book;
    }

    public Book updateBook(Integer id, Book updatedBook){
      Book existingBook =getBookbyId(id);
      if(existingBook !=null){
        existingBook.setTitle(updatedBook.getTitle());
        existingBook.setAuthor(updatedBook.getAuthor());
      }
      return existingBook;
    }

    public boolean deleteBook(Integer id){
      return books.removeIf(b->b.getId().equals(id));
    }

}
