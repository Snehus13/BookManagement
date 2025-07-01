package com.example.BookApplication.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


 @Entity   //to make it entity class
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
public class Book {
    @Id
    @GeneratedValue //so it will automaticall add higher value no need to add externally wrapper class.
    private Integer id;
    private String title;
    private String author;
    private  int price;

}
