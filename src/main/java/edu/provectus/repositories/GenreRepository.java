package edu.provectus.repositories;

import edu.provectus.model.Genre;

public interface GenreRepository extends GeneralRepository<Genre> {
    Genre getByName(String name);
}
