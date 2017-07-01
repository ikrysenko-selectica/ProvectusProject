package edu.provectus.repositories.impl;

import edu.provectus.model.Author;
import edu.provectus.repositories.AuthorRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

@Repository
public class AuthorRepositoryImpl implements AuthorRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Author add(Author author) {
        entityManager.persist(author);
        return author;
    }

    @Override
    public void update(Author author) {
        entityManager.merge(author);
    }

    @Override
    public void delete(Author author) {
        entityManager.createNativeQuery("DELETE FROM AUTHOR WHERE ID = ?1")
                .setParameter(1, author.getId())
                .executeUpdate();
    }

    @Override
    public Author getById(int id) {
        return entityManager.find(Author.class, id);
    }

    @Override
    public Author getByName(String name) {
        try {
            return (Author) entityManager.createNamedQuery("Author.getByName")
                    .setParameter("name", name)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
}
