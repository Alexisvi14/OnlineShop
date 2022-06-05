package com.solvd.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.Reader;

public class SessionFactory {
    private final static Logger LOGGER = LogManager.getLogger(SessionFactory.class);
    private static SessionFactory sessionFactory;
    private SqlSession session;

    private SessionFactory(){
        try(Reader reader = Resources.getResourceAsReader(Constants.MYBATIS_CONFIG)){
            session = new SqlSessionFactoryBuilder().build(reader).openSession();
        } catch (IOException e) {
            LOGGER.error("There was an error with mybatis", e);
            throw new RuntimeException(e);
        }
    }
    public static SessionFactory getInstance(){
        if (sessionFactory == null){
            return new SessionFactory();
        }
        return sessionFactory;
    }

    public SqlSession getSession(){
        return this.session;
    }
}
