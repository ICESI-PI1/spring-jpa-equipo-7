package com.icesi.bookmanager.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BookDTO {
    private Long authorId;
    private String title;
    private Date publicationDate;
}
