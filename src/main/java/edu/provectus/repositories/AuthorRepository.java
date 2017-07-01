package edu.provectus.repositories;

import edu.provectus.model.Author;

public interface AuthorRepository extends GeneralRepository<Author> {
    Author getByName(String name);
}
