package com.example.crud.controller;

import com.example.crud.entity.Book;
import com.example.crud.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
@RequestMapping("/api/v1")
public class BookController {

    private static final Logger log = LoggerFactory.getLogger(BookController.class);

    AtomicInteger atomicInteger = new AtomicInteger();

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("book")
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        return bookService.createBook(book);
    }

    @GetMapping("book/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) throws InterruptedException {
        var response = bookService.getBookById(id);
        var invokeCount = atomicInteger.incrementAndGet();
        // Thread.sleep(3000);
        log.info("count: {} response: {} on {}", invokeCount, response.getStatusCode(), Thread.currentThread());
        return bookService.getBookById(id);
    }

    @GetMapping("books")
    public ResponseEntity<List<Book>> getAllBooks() {
        return bookService.getAllBooks();
    }

    @PutMapping("book/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book book) {
        return bookService.updateBook(id, book);
    }

    @PatchMapping("book/{id}")
    public Book updatePartialBook(@PathVariable Long id, @RequestBody Map<String, Object> fields) {
        return bookService.updatePartialBook(id, fields);
    }

    @DeleteMapping("book/{id}")
    public ResponseEntity<HttpStatus> deleteBook(@PathVariable Long id) {
        return bookService.deleteBook(id);
    }
}
