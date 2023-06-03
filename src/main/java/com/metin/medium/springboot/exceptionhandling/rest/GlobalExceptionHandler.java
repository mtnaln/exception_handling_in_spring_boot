package com.metin.medium.springboot.exceptionhandling.rest;

import com.metin.medium.springboot.exceptionhandling.exception.AuthorNotFoundException;
import com.metin.medium.springboot.exceptionhandling.exception.BookNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

   @ExceptionHandler(BookNotFoundException.class)
    public String bookNotFoundException(BookNotFoundException exception) {
        return "[" + exception.getMessage() + "] adında bir kitap bulunamadı.";
    }

    @ExceptionHandler(AuthorNotFoundException.class)
    public String authorNotFoundException(AuthorNotFoundException exception) {
        return "[" + exception.getMessage() + "] adında bir yazar bulunamadı.";
    }

    @ExceptionHandler(Exception.class)
    public String otherAllException(Exception exception) {
        return "Exception Mesajı: " + exception.getMessage();
    }
}
