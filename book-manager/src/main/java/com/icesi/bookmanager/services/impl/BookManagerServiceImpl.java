package com.icesi.bookmanager.services.impl;

import com.icesi.bookmanager.dto.AuthorDTO;
import com.icesi.bookmanager.dto.BookDTO;
import com.icesi.bookmanager.repository.model.Author;
import com.icesi.bookmanager.repository.model.Book;
import com.icesi.bookmanager.repository.persistence.AuthorRepository;
import com.icesi.bookmanager.repository.persistence.BookRepository;
import com.icesi.bookmanager.services.IBookManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookManagerServiceImpl implements IBookManagerService {

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private AuthorRepository authorRepository;

    public BookManagerServiceImpl(BookRepository bookRepository,AuthorRepository authorRepository){
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }


    @Override
    public List<Book> listAllBooks() {

        return bookRepository.findAll();
    }

    @Override
    public List<Author> listAllAuthors() {
        return authorRepository.findAll();
    }

    @Override
    public Book getBookById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    @Override
    public Author getAuthorById(Long id) {
        return authorRepository.findById(id).orElse(null);

    }

    @Override
    public Boolean deleteBook(Long id) {
        Book existingBook = bookRepository.findById(id).orElse(null);
        if(existingBook != null){
            bookRepository.deleteById(id);
            return true;

        }
        return false;

    }

    @Override
    public Boolean deleteAuthor(Long id) {
        Author author = authorRepository.findById(id).orElse(null);
        if(author != null){
            authorRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Boolean createBook(BookDTO book) {

        Author author = authorRepository.findById(book.getAuthorId()).orElse(null);
        if(author != null){
            Book newBook = new Book();
            newBook.setTitle(book.getTitle());
            newBook.setPublicationDate(book.getPublicationDate());
            newBook.setAuthor(author);


            try {
                bookRepository.save(newBook);
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }

        }
        return false;
    }

    @Override
    public Boolean updateBook(Long id, BookDTO updatedBook) {
        Book existingBook = bookRepository.findById(id).orElse(null);
        if(existingBook != null){
            if(updatedBook.getAuthorId() != null){
                Author newAuthor = authorRepository.findById(updatedBook.getAuthorId()).orElse(null);
                if(newAuthor!=null){
                    existingBook.setAuthor(newAuthor);
                }
            }


            existingBook.setTitle(updatedBook.getTitle());
            existingBook.setPublicationDate(updatedBook.getPublicationDate());
            bookRepository.save(existingBook);
            return true;
        }
        return false;
    }

    @Override
    public Boolean createAuthor(Author author) {
        try {
            authorRepository.save(author);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Boolean updateAuthor(Long id, Author updatedAuthor) {
        Author existingAuthor = authorRepository.findById(id).orElse(null);

        if (existingAuthor != null){
            existingAuthor.setName(updatedAuthor.getName());
            existingAuthor.setNationality(updatedAuthor.getNationality());

            authorRepository.save(existingAuthor);

            return true;
        }

        return false;
    }

    @Override
    public List<Book> getBooksByAuthor(Long id) {
        Author author = authorRepository.findById(id).orElse(null);

        if(author != null){
            List<Book> books = bookRepository.findAll();

            return books.stream()
                    .filter(book -> author.equals(book.getAuthor()))
                    .collect(Collectors.toList());
        }

        return null;
    }
}
