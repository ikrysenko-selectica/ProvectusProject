package edu.provectus.controllers;

import edu.provectus.dto.book.BooksForOrderDTO;
import edu.provectus.dto.book.FullBookInfoDTO;
import edu.provectus.dto.order.OrderCreationDTO;
import edu.provectus.dto.order.OrderEditingDTO;
import edu.provectus.services.BookFilter;
import edu.provectus.services.BookOrderHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class ServiceForUserController {

    private final BookOrderHandler orderHandler;
    private final BookFilter bookFilter;

    @Autowired
    public ServiceForUserController(BookFilter bookFilter, BookOrderHandler orderHandler) {
        this.bookFilter = bookFilter;
        this.orderHandler = orderHandler;
    }

    @GetMapping("/get/all/books")
    public List<FullBookInfoDTO> getAllBooks() {
        return bookFilter.getBooks();
    }

    @GetMapping("/get/filtered/by/genre/{genreName}")
    public List<FullBookInfoDTO> getBooksFilteredByGenre(@PathVariable(name = "genreName") String genreName) {
        return bookFilter.getBooksByGenre(genreName);
    }

    @GetMapping("/get/filtered/by/authors/{authorName}")
    public List<FullBookInfoDTO> getBooksFilteredByAuthors(@PathVariable(name = "authorName") String authorName) {
        return bookFilter.getBooksByAuthor(authorName);
    }

    @GetMapping("/get/book/info/{bookId}")
    public FullBookInfoDTO getBookFullInfo(@PathVariable(name = "bookId") Integer bookId) {
        return bookFilter.getBookFullInfo(bookId);
    }

    @PostMapping("/edit/order/userfirstname")
    public void editUserFirstname(@RequestBody OrderEditingDTO editInfo) {
        orderHandler.editUserFirstname(editInfo.getOrderId(), editInfo.getEditLine());
    }

    @PostMapping("/edit/order/userlastname")
    public void editUserLastname(@RequestBody OrderEditingDTO editInfo) {
        orderHandler.editUserLastname(editInfo.getOrderId(), editInfo.getEditLine());
    }

    @PostMapping("/edit/order/useraddress")
    public void editUserAddress(@RequestBody OrderEditingDTO editInfo) {
        orderHandler.editUserAddress(editInfo.getOrderId(), editInfo.getEditLine());
    }

    @PostMapping("/add/order")
    public int createNewOrder(@RequestBody OrderCreationDTO orderCreationDTO) {
        return orderHandler.createOrderList(orderCreationDTO);
    }

    @PostMapping("/add/order/books")
    public void addBooksInOrder(@RequestBody BooksForOrderDTO booksForOrderDTO) {
        booksForOrderDTO.getBooksId().forEach(bookId ->
                orderHandler.addCurrentBookToOrderList(bookId, booksForOrderDTO.getOrderId()));
    }

    @PostMapping("/delete/order/books")
    public void deleteBooksFromOrder(@RequestBody BooksForOrderDTO booksForOrderDTO) {
        booksForOrderDTO.getBooksId().forEach(bookId ->
                orderHandler.deleteCurrentBookFromOrderList(bookId, booksForOrderDTO.getOrderId()));
    }

}
