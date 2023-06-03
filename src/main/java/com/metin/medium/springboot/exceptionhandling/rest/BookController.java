package com.metin.medium.springboot.exceptionhandling.rest;

import com.metin.medium.springboot.exceptionhandling.exception.BookNotFoundException;
import com.metin.medium.springboot.exceptionhandling.models.Book;
import com.metin.medium.springboot.exceptionhandling.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/{name}")
    public Book getBookByName(@PathVariable String name) {
        return bookService.getBookByName(name);
    }

    @GetMapping("/authors/{name}")
    public List<Book> getBooksByAuthor(@PathVariable("name") String authorName) {
        return bookService.getBooksByAuthor(authorName);
    }

    @GetMapping("/page-count/{count}")
    public Book getAnyBookMoreThanPageCount(@PathVariable("count") int count) {
        return bookService.getAnyBookMoreThanPageCount(count);
    }
}
