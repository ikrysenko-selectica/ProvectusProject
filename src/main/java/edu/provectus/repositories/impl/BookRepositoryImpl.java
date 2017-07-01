package edu.provectus.repositories.impl;

import edu.provectus.model.Book;
import edu.provectus.repositories.BookRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class BookRepositoryImpl implements BookRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Book add(Book book) {
        entityManager.persist(book);
        return book;
    }

    @Override
    public void update(Book book) {
        entityManager.merge(book);
    }

    @Override
    public void delete(Book book) {
        entityManager.createNativeQuery("DELETE FROM BOOK WHERE ID = ?1")
                .setParameter(1, book.getId())
                .executeUpdate();
    }

    @Override
    public Book getById(int id) {
        return entityManager.find(Book.class, id);
    }

    @Override
    public List<Book> getAllBooks() {
        return entityManager.createNamedQuery("Book.getAllBooks")
                .getResultList();
    }
}
