package edu.provectus.services.impl;

import edu.provectus.dto.book.FullBookInfoDTO;
import edu.provectus.model.Book;
import edu.provectus.repositories.AuthorRepository;
import edu.provectus.repositories.BookRepository;
import edu.provectus.repositories.GenreRepository;
import edu.provectus.services.BookFilter;
import edu.provectus.util.UtilTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookFilterImpl implements BookFilter {

    private final AuthorRepository authorRepository;
    private final GenreRepository genreRepository;
    private final BookRepository bookRepository;

    @Autowired
    public BookFilterImpl(AuthorRepository authorRepository, GenreRepository genreRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.genreRepository = genreRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    @Transactional
    public List<FullBookInfoDTO> getBooks() {
        List<FullBookInfoDTO> books = new ArrayList<>();
        bookRepository.getAllBooks().forEach(book -> books.add(new FullBookInfoDTO(
                        book.getId(),
                        book.getTitle(),
                        book.getDescription(),
                        book.getPrice(),
                        UtilTools.extractGenresNames(book.getGenres()),
                        UtilTools.extractAuthorsNames(book.getAuthors())
                ))
        );

        return books;
    }

    @Override
    @Transactional
    public List<FullBookInfoDTO> getBooksByGenre(String genre) {
        List<FullBookInfoDTO> filteredBooks = new ArrayList<>();
        List<Book> books = genreRepository.getByName(genre).getBooks();
        if (generalForFiltering(filteredBooks, books))
            return filteredBooks;

        return filteredBooks;
    }

    @Override
    @Transactional
    public List<FullBookInfoDTO> getBooksByAuthor(String author) {
        List<FullBookInfoDTO> filteredBooks = new ArrayList<>();
        List<Book> books = authorRepository.getByName(author).getBooks();
        if (generalForFiltering(filteredBooks, books))
            return filteredBooks;

        return filteredBooks;
    }

    private boolean generalForFiltering(List<FullBookInfoDTO> filteredBooks, List<Book> books) {
        if (books == null) {
            return true;
        }
        books.forEach(book -> filteredBooks.add(new FullBookInfoDTO(
                        book.getId(),
                        book.getTitle(),
                        book.getDescription(),
                        book.getPrice(),
                        UtilTools.extractGenresNames(book.getGenres()),
                        UtilTools.extractAuthorsNames(book.getAuthors())
                ))
        );
        return false;
    }


    @Override
    @Transactional
    public FullBookInfoDTO getBookFullInfo(int bookId) {
        Book book = bookRepository.getById(bookId);

        FullBookInfoDTO fullBookInfoDTO = new FullBookInfoDTO();
        fullBookInfoDTO.setBookId(book.getId());
        fullBookInfoDTO.setTitle(book.getTitle());
        fullBookInfoDTO.setDescription(book.getDescription());
        fullBookInfoDTO.setPrice(book.getPrice());
        fullBookInfoDTO.setAuthors(UtilTools.extractAuthorsNames(book.getAuthors()));
        fullBookInfoDTO.setGenres(UtilTools.extractGenresNames(book.getGenres()));

        return fullBookInfoDTO;
    }
}
