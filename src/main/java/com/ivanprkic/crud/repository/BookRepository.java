package com.ivanprkic.crud.repository;

import com.ivanprkic.crud.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {}
