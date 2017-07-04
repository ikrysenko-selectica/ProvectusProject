package edu.provectus.dto.book.edit;

public class BookEditPriceDTO {

    private int bookId;

    private double price;

    public BookEditPriceDTO() {
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
