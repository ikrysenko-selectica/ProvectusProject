package edu.provectus.dto.order;

import edu.provectus.dto.book.ShortBookInfoDTO;

import java.util.List;

public class OrderInfoDTO {

    private int id;

    private String buyerFirstName;

    private String buyerSecondName;

    private String address;

    private List<ShortBookInfoDTO> orderedBooks;

    private int quantityOfOrderedBooks;

    public OrderInfoDTO() {
    }

    public OrderInfoDTO(int id, String buyerFirstName, String buyerSecondName, String address, List<ShortBookInfoDTO> orderedBooks, int quantityOfOrderedBooks) {
        this.id = id;
        this.buyerFirstName = buyerFirstName;
        this.buyerSecondName = buyerSecondName;
        this.address = address;
        this.orderedBooks = orderedBooks;
        this.quantityOfOrderedBooks = quantityOfOrderedBooks;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBuyerFirstName() {
        return buyerFirstName;
    }

    public void setBuyerFirstName(String buyerFirstName) {
        this.buyerFirstName = buyerFirstName;
    }

    public String getBuyerSecondName() {
        return buyerSecondName;
    }

    public void setBuyerSecondName(String buyerSecondName) {
        this.buyerSecondName = buyerSecondName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<ShortBookInfoDTO> getOrderedBooks() {
        return orderedBooks;
    }

    public void setOrderedBooks(List<ShortBookInfoDTO> orderedBooks) {
        this.orderedBooks = orderedBooks;
    }

    public int getQuantityOfOrderedBooks() {
        return quantityOfOrderedBooks;
    }

    public void setQuantityOfOrderedBooks(int quantityOfOrderedBooks) {
        this.quantityOfOrderedBooks = quantityOfOrderedBooks;
    }
}
