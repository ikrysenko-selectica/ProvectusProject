package edu.provectus.services;

import edu.provectus.model.Book;

import java.util.List;

public interface AdminOptionsWithBook {

    void addNewBook(Book book);

    void addNewBookGenre(String genreName);

    void editBookTitle(int bookId, String newBookTitle);

    void editBookDescription(int bookId, String newBookDescription);

    void editBookPrice(int bookId, double newBookPrice);

    void editBookGenre(int bookId, List<String> newBookGenres);

    void editBookAuthors(int bookId, List<String> newBookAuthors);

}
