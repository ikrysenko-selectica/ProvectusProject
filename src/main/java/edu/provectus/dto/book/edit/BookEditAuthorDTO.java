package edu.provectus.dto.book.edit;

import java.util.List;

public class BookEditAuthorDTO {

    private int bookId;

    private List<String> authors;

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }
}
