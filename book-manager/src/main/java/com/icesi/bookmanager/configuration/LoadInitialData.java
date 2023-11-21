package com.icesi.bookmanager.configuration;


import com.icesi.bookmanager.repository.model.Author;
import com.icesi.bookmanager.repository.model.Book;
import com.icesi.bookmanager.repository.persistence.AuthorRepository;
import com.icesi.bookmanager.repository.persistence.BookRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.xml.crypto.Data;
import java.time.LocalDate;
import java.util.Date;

@Component
public class LoadInitialData {

    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private BookRepository bookRepository;

    public LoadInitialData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @PostConstruct
    public void loadInitialData(){
        Author ws = new Author("Haruki Murakami  ","Japanese");

        Book book_ws_1 = new Book();
        book_ws_1.setTitle("Norwegian Wood");
        book_ws_1.setPublicationDate(new Date(87, 0, 1));
        book_ws_1.setAuthor(ws);

        Book book_ws_2 = new Book();
        book_ws_2.setTitle("Kafka on the Shore");
        book_ws_2.setPublicationDate(new Date(2, 0, 1));
        book_ws_2.setAuthor(ws);

        authorRepository.save(ws);
        bookRepository.save(book_ws_1);
        bookRepository.save(book_ws_2);

        Author jkRowling = new Author("J.K. Rowling", "British");

        Book book_jk_1 = new Book();
        book_jk_1.setTitle("Harry Potter and the Philosopher's Stone");
        book_jk_1.setPublicationDate(new Date(97, 5, 26));
        book_jk_1.setAuthor(jkRowling);

        Book book_jk_2 = new Book();
        book_jk_2.setTitle("Harry Potter and the Chamber of Secrets");
        book_jk_2.setPublicationDate(new Date(98, 6, 2));
        book_jk_2.setAuthor(jkRowling);

        authorRepository.save(jkRowling);
        bookRepository.save(book_jk_1);
        bookRepository.save(book_jk_2);

        Author agathaChristie = new Author("Agatha Christie", "British");

        Book book_agatha_1 = new Book();
        book_agatha_1.setTitle("Murder on the Orient Express");
        book_agatha_1.setPublicationDate(new Date(34, 0, 1));
        book_agatha_1.setAuthor(agathaChristie);

        Book book_agatha_2 = new Book();
        book_agatha_2.setTitle("Death on the Nile");
        book_agatha_2.setPublicationDate(new Date(37, 0, 1));
        book_agatha_2.setAuthor(agathaChristie);

        authorRepository.save(agathaChristie);
        bookRepository.save(book_agatha_1);
        bookRepository.save(book_agatha_2);


        Author gabrielGarciaMarquez = new Author("Gabriel Garcia Marquez", "Colombian");

        Book book_gabriel_1 = new Book();
        book_gabriel_1.setTitle("One Hundred Years of Solitude");
        book_gabriel_1.setPublicationDate(new Date(67, 4, 30));
        book_gabriel_1.setAuthor(gabrielGarciaMarquez);

        Book book_gabriel_2 = new Book();
        book_gabriel_2.setTitle("Love in the Time of Cholera");
        book_gabriel_2.setPublicationDate(new Date(85, 5, 22));
        book_gabriel_2.setAuthor(gabrielGarciaMarquez);

        authorRepository.save(gabrielGarciaMarquez);
        bookRepository.save(book_gabriel_1);
        bookRepository.save(book_gabriel_2);


        Author chimamandaAdichie = new Author("Chimamanda Ngozi Adichie", "Nigerian");

        Book book_chimamanda_1 = new Book();
        book_chimamanda_1.setTitle("Purple Hibiscus");
        book_chimamanda_1.setPublicationDate(new Date(03, 10, 30));
        book_chimamanda_1.setAuthor(chimamandaAdichie);

        Book book_chimamanda_2 = new Book();
        book_chimamanda_2.setTitle("Half of a Yellow Sun");
        book_chimamanda_2.setPublicationDate(new Date(06, 7, 1));
        book_chimamanda_2.setAuthor(chimamandaAdichie);

        authorRepository.save(chimamandaAdichie);
        bookRepository.save(book_chimamanda_1);
        bookRepository.save(book_chimamanda_2);


    }
}
