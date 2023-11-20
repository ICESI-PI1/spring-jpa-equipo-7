package com.icesi.bookmanager.mapper;

import com.icesi.bookmanager.dto.AuthorDTO;
import com.icesi.bookmanager.dto.AuthorWithBooksDTO;
import com.icesi.bookmanager.dto.BookDTO;
import com.icesi.bookmanager.dto.BookInfoDTO;
import com.icesi.bookmanager.repository.model.Author;
import com.icesi.bookmanager.repository.model.Book;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class Mapper {

    public Author toAuthor(AuthorDTO authorDTO) {
        return new Author(authorDTO.getName(), authorDTO.getNationality());
    }


    public BookInfoDTO toBookInfoDTO(Book book){
        return new BookInfoDTO(book.getId(),book.getTitle(),book.getPublicationDate(),book.getAuthor().getName());
    }


    public List<BookInfoDTO> listAllBooks(List<Book> books) {

        return books.stream()
                .map(this::toBookInfoDTO)
                .collect(Collectors.toList());
    }


}
