package com.solvd.DAO;

public interface IEntityDAO<T> {
    void addEntity(T entity);

    T getEntity(long id);

    void updateEntity(T entity);

    void removeEntity(long id);
}
