package edu.provectus.services;

import edu.provectus.model.Book;

import java.util.List;


public interface BookFilter {

    public List<Book> getBooks();

    public List<Book> getBooksByGenre(String genre);

    List<Book> getBooksByAuthor(String author);

    public Book getBookInfo(int bookId);

}
