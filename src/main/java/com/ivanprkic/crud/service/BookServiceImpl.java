package com.ivanprkic.crud.service;

import com.ivanprkic.crud.entity.Book;
import com.ivanprkic.crud.exception.BookNotFoundException;
import com.ivanprkic.crud.repository.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@AllArgsConstructor
@Service
public class BookServiceImpl implements BookService {

    BookRepository bookRepository;

    @Override
    public Book getBookById(Long id) {
        Optional<Book> book = bookRepository.findById(id);
        if (book.isPresent()){
            return book.get();
        } else {
            throw new BookNotFoundException(id);
        }
    }

    @Override
    public Book updatePartialBook(Long id, Map<String, Object> fields) {
        Optional<Book> existingBook = bookRepository.findById(id);

        if (existingBook.isPresent()) {
            fields.forEach((key, value) -> {
                Field field = ReflectionUtils.findField(Book.class, key);
                field.setAccessible(true);
                ReflectionUtils.setField(field, existingBook.get(), value);
            });
            return bookRepository.save(existingBook.get());
        }

        return null;
    }

    @Override
    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    public ResponseEntity<List<Book>> getAllBooks() {
        try {

            List<Book> bookList = new ArrayList<>(bookRepository.findAll());

            if (bookList.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(bookList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    public ResponseEntity<Book> updateBook(Long id, Book book) {
        try {
            Optional<Book> bookData = bookRepository.findById(id);
            if (bookData.isPresent()) {
                Book updatedBook = bookData.get();
                updatedBook.setTitle(book.getTitle());
                updatedBook.setAuthor(book.getAuthor());

                return new ResponseEntity<>(bookRepository.save(updatedBook), HttpStatus.CREATED);
            }

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
