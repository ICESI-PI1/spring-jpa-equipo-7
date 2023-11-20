package com.icesi.bookmanager.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class AuthorWithBooksDTO {
    private String name;
    private String nationality;
    private List<BookDTO> books;
}
