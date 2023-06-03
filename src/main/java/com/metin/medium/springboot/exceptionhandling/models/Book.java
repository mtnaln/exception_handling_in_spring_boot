package com.metin.medium.springboot.exceptionhandling.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Book {
    private String name;
    private int pageCount;
    private String author;
}
