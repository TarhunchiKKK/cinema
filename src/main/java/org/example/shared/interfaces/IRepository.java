package org.example.shared.interfaces;

import java.util.List;

public interface IRepository<T> {
    void create(T entity);

    List<T> findAll();

    void update(T entity);

    void delete(Long id);
}
