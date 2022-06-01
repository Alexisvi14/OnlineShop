package com.solvd.DAO;

public interface IBaseDAO <T>{
    T getEntityById(long id);
    void saveEntity(T entity);
    void updateEntity(T entity);
    void removeEntity(long id);
}
