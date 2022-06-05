package com.solvd.dao;

import org.apache.ibatis.annotations.Param;

public interface IBaseDAO <T>{
    T getEntityById(long id);
    void saveEntity(@Param("entity") T entity);
    void updateEntity(@Param("entity") T entity);
    void removeEntity(long id);
}
