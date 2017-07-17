package edu.provectus.services.impl;

import edu.provectus.dto.order.OrderCreationDTO;
import edu.provectus.dto.order.OrderInfoDTO;
import edu.provectus.model.Book;
import edu.provectus.model.Order;
import edu.provectus.repositories.BookRepository;
import edu.provectus.repositories.OrderRepository;
import edu.provectus.services.BookOrderHandler;
import edu.provectus.util.UtilTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookOrderHandlerImpl implements BookOrderHandler {

    private final BookRepository bookRepository;
    private final OrderRepository orderRepository;

    @Autowired
    public BookOrderHandlerImpl(BookRepository bookRepository, OrderRepository orderRepository) {
        this.bookRepository = bookRepository;
        this.orderRepository = orderRepository;
    }

    @Override
    @Transactional
    public int createOrderList(OrderCreationDTO order) {
        Order newOrder = new Order();

        newOrder.setFirstName(order.getBuyerFirstName());
        newOrder.setLastName(order.getBuyerSecondName());
        newOrder.setAddress(order.getAddress());
        orderRepository.add(newOrder);

        return newOrder.getId();
    }

    @Override
    @Transactional
    public void addCurrentBookToOrderList(int bookId, int orderId) {
        Book book = bookRepository.getById(bookId);
        Order order = orderRepository.getById(orderId);

        if (order.getBooks() == null) {
            List<Book> books = new ArrayList<>();
            books.add(book);
            order.setBooks(books);
            order.setBooksQuantity(books.size());

            orderRepository.update(order);
        } else {
            order.getBooks().add(book);
            order.setBooksQuantity(order.getBooksQuantity() + 1);

            orderRepository.update(order);
        }

    }

    @Override
    @Transactional
    public void deleteCurrentBookFromOrderList(int bookId, int orderId) {
        Book book = bookRepository.getById(bookId);
        Order order = orderRepository.getById(orderId);

        order.getBooks().remove(book);
        order.setBooksQuantity(order.getBooksQuantity() - 1);
        orderRepository.update(order);
    }

    @Override
    @Transactional
    public OrderInfoDTO getFullOrderInfo(int orderId) {
        Order order = orderRepository.getById(orderId);

        OrderInfoDTO orderInfoDTO = new OrderInfoDTO();
        orderInfoDTO.setId(order.getId());
        orderInfoDTO.setBuyerFirstName(order.getFirstName());
        orderInfoDTO.setBuyerSecondName(order.getLastName());
        orderInfoDTO.setAddress(order.getAddress());
        orderInfoDTO.setOrderedBooks(UtilTools.convertBooksToBooksInfo(order.getBooks()));
        orderInfoDTO.setQuantityOfOrderedBooks(order.getBooksQuantity());

        return null;

    }

    @Override
    @Transactional
    public void editUserFirstname(int orderId, String firstname) {
        Order order = orderRepository.getById(orderId);
        order.setFirstName(firstname);
        orderRepository.update(order);
    }


    @Override
    @Transactional
    public void editUserLastname(int orderId, String lastname) {
        Order order = orderRepository.getById(orderId);
        order.setLastName(lastname);
        orderRepository.update(order);
    }

    @Override
    @Transactional
    public void editUserAddress(int orderId, String address) {
        Order order = orderRepository.getById(orderId);
        order.setAddress(address);
        orderRepository.update(order);
    }
}
