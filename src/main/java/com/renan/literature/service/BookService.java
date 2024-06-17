package com.renan.literature.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.renan.literature.dto.BookDTO;
import com.renan.literature.entity.Book;
import com.renan.literature.repository.BookRepository;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }   

    public List<BookDTO> getRegistered(){
        return convertData(bookRepository.findAll());
    }

    public List<Book> getAuthorsRegistered(){
        return bookRepository.getRegisteredAuthors();
    }

    public List<Book> getBooksLang(String lang){
        return bookRepository.booksLanguage(lang);
    }

    public List<BookDTO> convertData(List<Book> book){
        return book.stream()
                .map(b -> new BookDTO(b.getId(), b.getTitle(), b.getAuthor(), b.getLanguage(), b.getDownloads(),b.getBirthYear(),b.getDearthYear()))
                .collect(Collectors.toList());
    }
}