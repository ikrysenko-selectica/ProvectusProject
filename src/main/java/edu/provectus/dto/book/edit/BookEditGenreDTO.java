package edu.provectus.dto.book.edit;

import java.util.List;

public class BookEditGenreDTO {
    private int bookId;

    private List<String> genres;

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

}
