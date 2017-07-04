package edu.provectus.dto.order;

public class OrderEditingDTO {

    private int orderId;

    private String editLine;

    public OrderEditingDTO() {
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getEditLine() {
        return editLine;
    }

    public void setEditLine(String editLine) {
        this.editLine = editLine;
    }
}
