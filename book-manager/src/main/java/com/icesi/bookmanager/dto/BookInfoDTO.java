package com.icesi.bookmanager.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BookInfoDTO {
    private Long book_id;
    private String title;
    private Date publicationDate;
    private String authorName;
}
