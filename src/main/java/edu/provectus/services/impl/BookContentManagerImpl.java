package edu.provectus.services.impl;

import edu.provectus.dto.book.FullBookInfoDTO;
import edu.provectus.model.Author;
import edu.provectus.model.Book;
import edu.provectus.model.Genre;
import edu.provectus.repositories.AuthorRepository;
import edu.provectus.repositories.BookRepository;
import edu.provectus.repositories.GenreRepository;
import edu.provectus.services.BookContentManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookContentManagerImpl implements BookContentManager {

    private final BookRepository bookRepository;
    private final AuthorManager authorManager;
    private final GenreManager genreManager;
    private final GenreRepository genreRepository;
    private final AuthorRepository authorRepository;

    @Autowired
    public BookContentManagerImpl(BookRepository bookRepository, AuthorManager authorManager, GenreManager genreManager, GenreRepository genreRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorManager = authorManager;
        this.genreManager = genreManager;
        this.genreRepository = genreRepository;
        this.authorRepository = authorRepository;
    }


    @Override
    @Transactional
    public void addNewBook(FullBookInfoDTO fullBookInfoDTO) {
        Book book = new Book();

        book.setTitle(fullBookInfoDTO.getTitle());
        book.setDescription(fullBookInfoDTO.getDescription());
        book.setPrice(fullBookInfoDTO.getPrice());

        bookRepository.add(book);

        authorManager.manageAuthors(book, fullBookInfoDTO.getAuthors());
        genreManager.manageGenres(book, fullBookInfoDTO.getGenres());

    }

    @Override
    public void addNewBookGenre(String genreName) {
        Genre genre = new Genre();
        genre.setName(genreName);

        genreRepository.add(genre);
    }

    @Override
    public void addNewBookAuthor(String authorName) {
        Author author = new Author();
        author.setName(authorName);

        authorRepository.add(author);
    }

    @Override
    @Transactional
    public void editBookTitle(int bookId, String newBookTitle) {
        Book book = bookRepository.getById(bookId);
        book.setTitle(newBookTitle);
        bookRepository.update(book);
    }

    @Override
    @Transactional
    public void editBookDescription(int bookId, String newBookDescription) {
        Book book = bookRepository.getById(bookId);
        book.setDescription(newBookDescription);
        bookRepository.update(book);
    }

    @Override
    @Transactional
    public void editBookPrice(int bookId, double newBookPrice) {
        Book book = bookRepository.getById(bookId);
        book.setPrice(newBookPrice);
        bookRepository.update(book);
    }

    @Override
    @Transactional
    public void editBookGenre(int bookId, List<String> newBookGenres) {
        List<Genre> genresForEdit = new ArrayList<>();
        newBookGenres.forEach(genreName -> genresForEdit.add(genreRepository.getByName(genreName)));

        Book book = bookRepository.getById(bookId);
        book.setGenres(genresForEdit);
        bookRepository.update(book);
    }

    @Override
    @Transactional
    public void editBookAuthors(int bookId, List<String> newBookAuthors) {
        Book book = bookRepository.getById(bookId);
        List<Author> newAuthors = new ArrayList<>();

        newBookAuthors.forEach(author -> {
            Author newAuthor = new Author();
            newAuthor.setName(author);

            authorRepository.add(newAuthor);
            newAuthors.add(newAuthor);
        });

        book.setAuthors(newAuthors);
        bookRepository.update(book);
    }

}
