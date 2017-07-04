package edu.provectus.dto.order;

public class OrderCreationDTO {

    private String buyerFirstName;

    private String buyerSecondName;

    private String address;

    public OrderCreationDTO() {
    }

    public OrderCreationDTO(String buyerFirstName, String buyerSecondName, String address) {
        this.buyerFirstName = buyerFirstName;
        this.buyerSecondName = buyerSecondName;
        this.address = address;
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
}
