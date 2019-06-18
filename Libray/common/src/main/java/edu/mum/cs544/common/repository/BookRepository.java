package edu.mum.cs544.common.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.mum.cs544.common.domain.Book;

public interface BookRepository extends JpaRepository<Book, String>{

}
