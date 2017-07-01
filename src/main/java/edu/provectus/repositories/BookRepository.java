package edu.provectus.repositories;

import edu.provectus.model.Book;

import java.util.List;


public interface BookRepository extends GeneralRepository<Book> {
    List<Book> getAllBooks();
}
