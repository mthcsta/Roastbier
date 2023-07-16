package com.roastbier.roastbier.dao;

import java.util.List;

public interface DAO<T, U> {

    public T getById(U id);

    public List<T> getAll();

    public void update(T entity);

    public void create(T entity);
}
