package edu.provectus.repositories.impl;

import edu.provectus.model.Genre;
import edu.provectus.repositories.GenreRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

@Repository
public class GenreRepositoryImpl implements GenreRepository{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Genre add(Genre genre) {
        entityManager.persist(genre);
        return genre;
    }

    @Override
    public void update(Genre genre) {
        entityManager.merge(genre);
    }

    @Override
    public void delete(Genre genre) {
        entityManager.createNativeQuery("DELETE FROM GENRE WHERE ID = ?1")
                .setParameter(1, genre.getId())
                .executeUpdate();
    }

    @Override
    public Genre getById(int id) {
        return entityManager.find(Genre.class, id);
    }

    @Override
    public Genre getByName(String name) {
        try {
            return (Genre) entityManager.createNamedQuery("Genre.getByName")
                    .setParameter("name", name)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
}
