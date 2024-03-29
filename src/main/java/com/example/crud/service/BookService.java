package com.example.crud.service;

import com.example.crud.entity.Book;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;

public interface BookService {
    ResponseEntity<Book> createBook(@RequestBody Book book);
    ResponseEntity<Book> getBookById(@PathVariable Long id);
    ResponseEntity<List<Book>> getAllBooks();
    ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book book);
    Book updatePartialBook(@PathVariable Long id, @RequestBody Map<String, Object> fields);
    ResponseEntity<HttpStatus> deleteBook(@PathVariable Long id);
}
