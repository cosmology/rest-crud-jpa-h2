package com.ivanprkic.crud.service;

import com.ivanprkic.crud.entity.Book;
import com.ivanprkic.crud.exception.BookNotFoundException;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface BookService {
    Book createBook(Book book);
    Book getBookById(Long id);
    ResponseEntity<List<Book>> getAllBooks();
    ResponseEntity<Book> updateBook(Long id, Book book);
    Book updatePartialBook(Long id, Map<String, Object> fields);
    void deleteBook(Long id) throws BookNotFoundException;
}
