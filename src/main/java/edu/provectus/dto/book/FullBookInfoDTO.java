package edu.provectus.dto.book;

import java.util.List;

public class FullBookInfoDTO {

    private int bookId;

    private String title;

    private String description;

    private double price;

    private List<String> genres;

    private List<String> authors;

    public FullBookInfoDTO() {
    }

    public FullBookInfoDTO(int bookId, String title, String description, double price, List<String> genres, List<String> authors) {
        this.bookId = bookId;
        this.title = title;
        this.description = description;
        this.price = price;
        this.genres = genres;
        this.authors = authors;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }
}
