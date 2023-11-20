package com.icesi.bookmanager.repository.persistence;

import com.icesi.bookmanager.repository.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author,Long> {
}

