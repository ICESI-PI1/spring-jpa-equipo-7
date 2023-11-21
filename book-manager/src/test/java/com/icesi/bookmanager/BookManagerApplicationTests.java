package com.icesi.bookmanager;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.icesi.bookmanager.dto.BookDTO;
import com.icesi.bookmanager.repository.model.Author;
import com.icesi.bookmanager.repository.model.Book;
import com.icesi.bookmanager.repository.persistence.AuthorRepository;
import com.icesi.bookmanager.repository.persistence.BookRepository;
import com.icesi.bookmanager.repository.persistence.UserRepository;
import com.icesi.bookmanager.services.AuthService;
import com.icesi.bookmanager.services.JwtService;
import com.icesi.bookmanager.services.impl.BookManagerServiceImpl;

@SpringBootTest
class BookManagerApplicationTests {

	@Test
	void contextLoads() {
	}
	@Mock
    private BookRepository bookRepository;

    @Mock
    private AuthorRepository authorRepository;

    @InjectMocks
    private BookManagerServiceImpl bookManagerService;

	@Mock
    private UserRepository userRepository;

    @Mock
    private JwtService jwtService;

    @Mock
    private AuthenticationManager authenticationManager;

    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    private AuthService authService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }


    @Test
    void listAllBooks() {
        // Arrange
        List<Book> books = new ArrayList<>();
        when(bookRepository.findAll()).thenReturn(books);

        // Act
        List<Book> result = bookManagerService.listAllBooks();

        // Assert
        assertEquals(books, result);
    }

    @Test
    void listAllAuthors() {
        // Arrange
        List<Author> authors = new ArrayList<>();
        when(authorRepository.findAll()).thenReturn(authors);

        // Act
        List<Author> result = bookManagerService.listAllAuthors();

        // Assert
        assertEquals(authors, result);
    }

    @Test
    void getBookById() {
        // Arrange
        Long bookId = 1L;
        Book expectedBook = new Book();
        when(bookRepository.findById(bookId)).thenReturn(Optional.of(expectedBook));

        // Act
        Book result = bookManagerService.getBookById(bookId);

        // Assert
        assertEquals(expectedBook, result);
    }

    @Test
    void getAuthorById() {
        // Arrange
        Long authorId = 1L;
        Author expectedAuthor = new Author();
        when(authorRepository.findById(authorId)).thenReturn(Optional.of(expectedAuthor));

        // Act
        Author result = bookManagerService.getAuthorById(authorId);

        // Assert
        assertEquals(expectedAuthor, result);
    }

    @Test
    void deleteBook() {
        // Arrange
        Long bookId = 1L;
        when(bookRepository.findById(bookId)).thenReturn(Optional.of(new Book()));

        // Act
        boolean result = bookManagerService.deleteBook(bookId);

        // Assert
        assertTrue(result);
        verify(bookRepository, times(1)).deleteById(bookId);
    }

    @Test
    void deleteAuthor() {
        // Arrange
        Long authorId = 1L;
        when(authorRepository.findById(authorId)).thenReturn(Optional.of(new Author()));

        // Act
        boolean result = bookManagerService.deleteAuthor(authorId);

        // Assert
        assertTrue(result);
        verify(authorRepository, times(1)).deleteById(authorId);
    }

    @Test
    void createBook() {
        // Arrange
        BookDTO bookDTO = new BookDTO();
        bookDTO.setTitle("Test Book");
        bookDTO.setAuthorId(1L);

        Author author = new Author();
        when(authorRepository.findById(bookDTO.getAuthorId())).thenReturn(Optional.of(author));

        // Act
        boolean result = bookManagerService.createBook(bookDTO);

        // Assert
        assertTrue(result);
        verify(bookRepository, times(1)).save(any(Book.class));
    }

    @Test
    void updateBook() {
        // Arrange
        Long bookId = 1L;
        BookDTO updatedBookDTO = new BookDTO();
        updatedBookDTO.setTitle("Updated Book");
        updatedBookDTO.setAuthorId(2L);

        Book existingBook = new Book();
        when(bookRepository.findById(bookId)).thenReturn(Optional.of(existingBook));

        Author newAuthor = new Author();
        when(authorRepository.findById(updatedBookDTO.getAuthorId())).thenReturn(Optional.of(newAuthor));

        // Act
        boolean result = bookManagerService.updateBook(bookId, updatedBookDTO);

        // Assert
        assertTrue(result);
        verify(bookRepository, times(1)).save(existingBook);
    }

    @Test
    void createAuthor() {
        // Arrange
        Author author = new Author();

        // Act
        boolean result = bookManagerService.createAuthor(author);

        // Assert
        assertTrue(result);
        verify(authorRepository, times(1)).save(author);
    }

    @Test
    void updateAuthor() {
        // Arrange
        Long authorId = 1L;
        Author updatedAuthor = new Author();
        updatedAuthor.setName("Updated Author");
        updatedAuthor.setNationality("Updated Nationality");

        Author existingAuthor = new Author();
        when(authorRepository.findById(authorId)).thenReturn(Optional.of(existingAuthor));

        // Act
        boolean result = bookManagerService.updateAuthor(authorId, updatedAuthor);

        // Assert
        assertTrue(result);
        verify(authorRepository, times(1)).save(existingAuthor);
    }

    

}

