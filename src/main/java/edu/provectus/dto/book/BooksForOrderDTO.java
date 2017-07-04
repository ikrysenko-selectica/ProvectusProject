package edu.provectus.dto.book;

import java.util.List;

public class BooksForOrderDTO {

    private int orderId;

    private List<Integer> booksId;

    public BooksForOrderDTO() {
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public List<Integer> getBooksId() {
        return booksId;
    }

    public void setBooksId(List<Integer> booksId) {
        this.booksId = booksId;
    }
}
