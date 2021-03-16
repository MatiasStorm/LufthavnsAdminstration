package com.cph.adminstration.repository.dao;

import java.util.List;

public interface CRUD_DAO<T, K> {

    T create(T t);
    List<T> readAll();
    T getByID(K id);
    void update(T t);
    void delete(K id);
}
