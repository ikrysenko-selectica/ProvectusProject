package edu.provectus.services;

import edu.provectus.dto.book.FullBookInfoDTO;

import java.util.List;

public interface BookContentManager {

    public void addNewBook(FullBookInfoDTO fullBookInfoDTO);

    public void addNewBookGenre(String genreName);

    public void editBookTitle(int bookId, String newBookTitle);

    public void editBookDescription(int bookId, String newBookDescription);

    public void editBookPrice(int bookId, double newBookPrice);

    public void editBookGenre(int bookId, List<String> newBookGenres);

    public void editBookAuthors(int bookId, List<String> newBookAuthors);
}
