package edu.provectus.controllers;

import com.fasterxml.jackson.databind.node.TextNode;
import edu.provectus.dto.book.FullBookInfoDTO;
import edu.provectus.dto.book.edit.BookEditAuthorDTO;
import edu.provectus.dto.book.edit.BookEditGenreDTO;
import edu.provectus.dto.book.edit.BookEditLineDTO;
import edu.provectus.dto.book.edit.BookEditPriceDTO;
import edu.provectus.services.BookContentManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class ContentManagementController {

    private final BookContentManager contentManager;

    @Autowired
    public ContentManagementController(BookContentManager contentManager) {
        this.contentManager = contentManager;
    }

    @PostMapping("/book/add")
    public void addNewBook(@RequestBody FullBookInfoDTO fullBookInfoDTO) {
        contentManager.addNewBook(fullBookInfoDTO);
    }

    @PostMapping("/book/edit/title")
    public void editBooksTitle(@RequestBody BookEditLineDTO bookEditInfo) {
        contentManager.editBookTitle(bookEditInfo.getBookId(), bookEditInfo.getLineToEdit());
    }

    @PostMapping("/book/edit/description")
    public void editBooksDescription(@RequestBody BookEditLineDTO bookEditInfo) {
        contentManager.editBookDescription(bookEditInfo.getBookId(), bookEditInfo.getLineToEdit());
    }

    @PostMapping("/book/edit/price")
    public void editBooksPrice(@RequestBody BookEditPriceDTO bookEditPriceDTO) {
        contentManager.editBookPrice(bookEditPriceDTO.getBookId(), bookEditPriceDTO.getPrice());
    }

    @PostMapping("/book/edit/genre")
    public void editBooksGenre(@RequestBody BookEditGenreDTO bookEditGenreDTO) {
        contentManager.editBookGenre(bookEditGenreDTO.getBookId(), bookEditGenreDTO.getGenres());
    }

    @PostMapping("/book/edit/author")
    public void editBooksAuthors(@RequestBody BookEditAuthorDTO bookEditAuthorDTO) {
        contentManager.editBookAuthors(bookEditAuthorDTO.getBookId(), bookEditAuthorDTO.getAuthors());
    }

    @GetMapping("/genre/add/{genreName}")
    public void addNewGenre(@PathVariable(name = "genreName") String genreName) {
        contentManager.addNewBookGenre(genreName);
    }

    @PostMapping("/author/add/{authorName}")
    public void addNewAuthor(@PathVariable(name = "authorName") String authorName) {
        contentManager.addNewBookAuthor(authorName);
    }

}
