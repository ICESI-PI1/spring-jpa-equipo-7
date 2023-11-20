package com.icesi.bookmanager.controllers;

import com.icesi.bookmanager.dto.AuthorDTO;
import com.icesi.bookmanager.dto.BookInfoDTO;
import com.icesi.bookmanager.mapper.Mapper;
import com.icesi.bookmanager.repository.model.Author;
import com.icesi.bookmanager.repository.model.Book;
import com.icesi.bookmanager.services.IBookManagerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/autores")
@RequiredArgsConstructor
public class AuthorController {
    @Autowired
    private IBookManagerService service;
    @Autowired
    private Mapper mapper;

    public AuthorController(IBookManagerService service,Mapper mapper){
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping
    public List<Author> listAllAuthors() {
        return service.listAllAuthors();
    }



    @PostMapping
    public boolean createAuthor(@RequestBody AuthorDTO authorDTO) {
        return service.createAuthor(mapper.toAuthor(authorDTO));
    }

    @GetMapping("/{id}")
    public Author getAuthorById(@PathVariable Long id) {
        return service.getAuthorById(id);
    }

    @PutMapping("/{id}")
    public boolean updateAuthor(@PathVariable Long id, @RequestBody AuthorDTO authorDTO) {
        return service.updateAuthor(id, mapper.toAuthor(authorDTO));
    }

    @DeleteMapping("/{id}")
    public Boolean deleteAuthor(@PathVariable Long id) {
        return service.deleteAuthor(id);
    }

    @GetMapping("/{id}/libros")
    public List<BookInfoDTO> getBooksByAuthor(@PathVariable Long id) {
        return mapper.listAllBooks(service.getBooksByAuthor(id));
    }
}
