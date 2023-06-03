package com.metin.medium.springboot.exceptionhandling.service;

import com.metin.medium.springboot.exceptionhandling.exception.AuthorNotFoundException;
import com.metin.medium.springboot.exceptionhandling.exception.BookNotFoundException;
import com.metin.medium.springboot.exceptionhandling.models.Book;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {

    private List<Book> books;

    @PostConstruct
    public void init() {
        books = new ArrayList<>();
        books.add(new Book("halka", 280, "Koci Suzuki"));
        books.add(new Book("mülksüzler", 344, "Ursula K. Le Guin"));
        books.add(new Book("gözlerinin ardında", 368, "Sarah Pinboroug"));
        books.add(new Book("istanbul hatırası", 628, "Ahmet Ümit"));
    }

    public Book getBookByName(String name) {
        return books.stream().filter(book -> name.equals(book.getName())).findFirst()
                .orElseThrow(() -> new BookNotFoundException(name));
    }

    public List<Book> getBooksByAuthor(String authorName) {
        boolean authorFound = books.stream().anyMatch(t -> authorName.equals(t.getAuthor()));
        if (!authorFound) {
            throw new AuthorNotFoundException(authorName);
        }

        return books.stream().filter(t -> authorName.equals(t.getAuthor())).collect(Collectors.toList());
    }

    public Book getAnyBookMoreThanPageCount(int pageCount) {
        return books.stream().filter(t -> t.getPageCount() > pageCount).findFirst().get();
    }
}
