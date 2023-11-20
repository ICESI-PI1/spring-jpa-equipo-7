package com.icesi.bookmanager.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AuthorDTO {
        private Long id;
        private String name;
        private String nationality;
}
