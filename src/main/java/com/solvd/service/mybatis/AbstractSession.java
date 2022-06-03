package com.solvd.service.mybatis;

import com.solvd.util.Constants;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.Reader;

public abstract class AbstractSession {
    private final static Logger LOGGER = LogManager.getLogger(AbstractSession.class);

    public SqlSession sqlSession(){
        Reader reader = null;
        try {
            reader = Resources.getResourceAsReader(Constants.MYBATIS_CONFIG);
        } catch (IOException e) {
            LOGGER.error("Error while getting resources", e);
        }
        SqlSessionFactory sql = new SqlSessionFactoryBuilder().build(reader);
        try(SqlSession session = sql.openSession()) {
            return session;
        }
    }
}
