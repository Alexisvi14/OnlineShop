package com.solvd.DAO;

import java.util.List;

public interface IBaseDAO <T>{
    T getEntityById(long id);
    void saveEntity(T entity);
    void updateEntity(T entity);
    void removeEntity(long id);
}
