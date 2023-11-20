package com.icesi.bookmanager.services;

import com.icesi.bookmanager.dto.AuthorDTO;
import com.icesi.bookmanager.dto.BookDTO;
import com.icesi.bookmanager.repository.model.Author;
import com.icesi.bookmanager.repository.model.Book;

import java.util.List;

public interface IBookManagerService {
    List<Book> listAllBooks();
    List<Author> listAllAuthors();
    Book getBookById(Long id);
    Author getAuthorById(Long id);
    Boolean deleteBook(Long id);
    Boolean deleteAuthor(Long id);
    Boolean createBook(BookDTO book);
    Boolean updateBook(Long id, BookDTO updatedBook);
    Boolean createAuthor(Author author);
    Boolean updateAuthor(Long id, Author updatedAuthor);
    List<Book> getBooksByAuthor(Long id);
}
