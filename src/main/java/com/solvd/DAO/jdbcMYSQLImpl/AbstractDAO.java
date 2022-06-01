package com.solvd.DAO.jdbcMYSQLImpl;

import com.solvd.util.ConnectionPool;

import java.sql.Connection;

public abstract class AbstractDAO {
    public Connection getConnection(){
        return ConnectionPool.getInstance().getConnection();
    }
    void returnConnection(Connection connection){
        ConnectionPool.getInstance().returnConnection(connection);
    }
}
