package edu.provectus.repositories;

public interface GeneralRepository<T> {
    T add(T item);

    void update(T item);

    void delete(T item);

    T getById(int id);
}
