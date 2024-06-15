package com.renan.literature.principal;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import com.renan.literature.api.Api;
import com.renan.literature.dto.BookDTO;
import com.renan.literature.entity.Book;
import com.renan.literature.model.ConvertData;
import com.renan.literature.model.DataBooks;
import com.renan.literature.service.BookService;

public class Principal {
    private final BookService bookService;

    public Principal(BookService bookService) {
        this.bookService = bookService;
    }

    ConvertData converter = new ConvertData();
    Api api = new Api();
    Scanner sc = new Scanner(System.in);
    protected final String BASE_URL = "https://gutendex.com/books/?search=";
    int option = -1;

    public void displayMenu() throws IOException, InterruptedException {
        do {
            System.out.printf("""
                    \n
                    ------------------------------------------------
                    Opções:

                    1 - Buscar livro por título
                    2 - Listar livros registrados
                    3 - Listar autores registrados
                    4 - Listar livros em um determinado idioma

                    0 - SAIR

                    Escolha sua opção:
                    """);
            option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 1:
                    System.out.println("Digite o título do livro que deseja buscar:");
                    var title = sc.nextLine();
                    String modifiedTitle = title.replace(" ", "+");
                    searchBookByTitle(modifiedTitle);
                    break;
                case 2:
                    registeredBooks();
                    break;
                default:
                    break;
            }

        } while (option != 0);

        sc.close();

    }

    private void registeredBooks() {
        List<BookDTO> booksRegistered = bookService.getRegistered();
        for(BookDTO bookRegistered: booksRegistered){
            System.out.printf("""
                ---------- Books Registered ----------

                Título : %s                          Idiomas: %s

                Autor: %s                            Download: %s

                            
                    """,bookRegistered.title(),bookRegistered.language(), bookRegistered.author(), bookRegistered.downloads());
        }
    }

    public void searchBookByTitle(String title) throws IOException, InterruptedException {

        String json = api.getApiResults(BASE_URL + title);
        DataBooks data = converter.getData(json, DataBooks.class);
        List<DataBooks> books = data.results();

        if (books.size() > 0) {
            for (DataBooks bookData : books) {
                String authors = bookData.authors()
                        .stream()
                        .map(a -> a.name())
                        .collect(Collectors.joining(", "));

                String languages = bookData.languages()
                        .stream()
                        .collect(Collectors.joining(", "));

                Book book = new Book();
                book.setTitle(bookData.title());
                book.setAuthor(authors);
                book.setLanguage(languages);
                book.setDownloads(bookData.downloads());

                bookService.saveBook(book);
                
                System.out.printf("""
                        ------------------- BOOK -------------------------
                            Título : %s

                            Autor: %s

                            Download: %s

                            Idiomas: %s
                        """, bookData.title(), authors, bookData.downloads(), languages);
            }
        } else {
            System.out.println("\n Livro não encontrado, tente novamente\n");
        }
    }

}
