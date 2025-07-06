package com.example.BookApplication.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.BookApplication.Entity.Book;

public interface BookRepository extends JpaRepository<Book, Long>{
      /*
      this interface will do all the job for us we no need to write any code to add book inside
       database .
       */ 
}
