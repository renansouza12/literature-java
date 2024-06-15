package com.renan.literature.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.renan.literature.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long> {}
