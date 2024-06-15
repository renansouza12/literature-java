package com.renan.literature;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.renan.literature.entity.Book;
import com.renan.literature.principal.Principal;
import com.renan.literature.service.BookService;

@SpringBootApplication
public class LiteratureApplication implements CommandLineRunner{

	@Autowired
    private BookService bookService;

	public static void main(String[] args) {
		SpringApplication.run(LiteratureApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		var principal = new Principal(bookService);
		principal.displayMenu();
	}


}
