package edu.provectus.services.impl;

import edu.provectus.model.Book;
import edu.provectus.model.Genre;
import edu.provectus.repositories.BookRepository;
import edu.provectus.repositories.GenreRepository;
import edu.provectus.util.UtilTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

public class GenreManager {

    private final GenreRepository genreRepository;
    private final BookRepository bookRepository;

    @Autowired
    public GenreManager(GenreRepository genreRepository, BookRepository bookRepository) {
        this.genreRepository = genreRepository;
        this.bookRepository = bookRepository;
    }

    @Transactional
    public void manageGenres(Book book, List<String> newOrUpdatedGenres) {

        List<Genre> genres = book.getGenres();

        if (genres == null || genres.size() == 0) {
            newOrUpdatedGenres.forEach(genre -> bindBookAndGenre(book, genre));

        } else if (newOrUpdatedGenres.size() == 0) {
            unbindAllGenresFromBook(book);

        } else {
            List<String> bookGenresNames = UtilTools.extractGenresNames(genres);
            List<String> intersection = new ArrayList<String>(newOrUpdatedGenres);
            intersection.retainAll(bookGenresNames);
            newOrUpdatedGenres.removeAll(intersection);

            newOrUpdatedGenres.forEach(genre -> bindBookAndGenre(book, genre));
        }

    }

    @Transactional
    private void bindBookAndGenre(Book book, String genreName) {

        Genre genre = genreRepository.getByName(genreName);

        if (genre == null) {
            Genre newGenre = new Genre();
            newGenre.setName(genreName);
            List<Book> books = new ArrayList<>();
            books.add(book);
            newGenre.setBooks(books);

            genreRepository.add(newGenre);
        } else {

            List<Book> books = genre.getBooks();
            books.add(book);
            genre.setBooks(books);

            genreRepository.update(genre);
        }

    }

    @Transactional
    private void unbindAllGenresFromBook(Book book) {
        book.setGenres(new ArrayList<>());
        bookRepository.update(book);

    }

}
