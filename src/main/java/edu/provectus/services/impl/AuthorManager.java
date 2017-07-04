package edu.provectus.services.impl;

import edu.provectus.model.Author;
import edu.provectus.model.Book;
import edu.provectus.repositories.AuthorRepository;
import edu.provectus.repositories.BookRepository;
import edu.provectus.util.UtilTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

public class AuthorManager {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    @Autowired
    public AuthorManager(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Transactional
    public void manageAuthors(Book book, List<String> newOrUpdatedAuthors){

        List<Author> authors = book.getAuthors();

        if (authors == null || authors.size() == 0) {
            newOrUpdatedAuthors.forEach(author -> bindBookAndAuthor(book, author));

        } else if (newOrUpdatedAuthors.size() == 0) {
            unbindAllAuthorsFromBook(book);

        } else {
            List<String> bookAuthorsNames = UtilTools.extractAuthorsNames(authors);
            List<String> intersection = new ArrayList<String>(newOrUpdatedAuthors);
            intersection.retainAll(bookAuthorsNames);
            newOrUpdatedAuthors.removeAll(intersection);

            newOrUpdatedAuthors.forEach(author -> bindBookAndAuthor(book, author));
        }
    }

    @Transactional
    private void bindBookAndAuthor(Book book, String authorName){
        Author author = authorRepository.getByName(authorName);

        if(author == null){
            Author newAuthor = new Author();
            newAuthor.setName(authorName);
            List<Book> books = new ArrayList<>();
            books.add(book);
            newAuthor.setBooks(books);

            authorRepository.add(newAuthor);
        } else {

            List<Book> books = author.getBooks();
            books.add(book);
            author.setBooks(books);

            authorRepository.update(author);
        }

    }

    @Transactional
    private void unbindAllAuthorsFromBook(Book book){
        book.setAuthors(new ArrayList<>());
        bookRepository.update(book);

    }

}
