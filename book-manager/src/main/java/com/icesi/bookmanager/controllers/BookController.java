package com.icesi.bookmanager.controllers;

import com.icesi.bookmanager.dto.BookDTO;
import com.icesi.bookmanager.dto.BookInfoDTO;
import com.icesi.bookmanager.mapper.Mapper;
import com.icesi.bookmanager.repository.model.Book;
import com.icesi.bookmanager.services.IBookManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/libros")
public class BookController {

    @Autowired
    private IBookManagerService service;
    @Autowired
    private Mapper mapper;

    public BookController(IBookManagerService service,Mapper mapper){
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping
    public List<BookInfoDTO> listAllBooks() {

        return mapper.listAllBooks(service.listAllBooks());
    }


    @PostMapping
    public Boolean createBook(@RequestBody BookDTO book) {
        return service.createBook(book);
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id) {
        return service.getBookById(id);
    }

    @PutMapping("/{id}")
    public Boolean updateBook(@PathVariable Long id, @RequestBody BookDTO updatedBook) {
        return service.updateBook(id, updatedBook);
    }

    @DeleteMapping("/{id}")
    public Boolean deleteBook(@PathVariable Long id) {
        return service.deleteBook(id);
    }


}
