package edu.provectus.services;

import edu.provectus.dto.order.OrderCreationDTO;
import edu.provectus.dto.order.OrderInfoDTO;

public interface BookOrderHandler {

    public int createOrderList(OrderCreationDTO order);

    public void addCurrentBookToOrderList(int bookId, int orderId);

    public void deleteCurrentBookFromOrderList(int bookId, int orderId);

    public OrderInfoDTO getFullOrderInfo(int orderId);

    public void editUserFirstname(int orderId, String firstname);

    public void editUserLastname(int orderId, String lastname);

    public void editUserAddress(int orderId, String address);

}
