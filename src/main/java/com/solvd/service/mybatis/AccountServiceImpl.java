package com.solvd.service.mybatis;

import com.solvd.DAO.IAccountDAO;
import com.solvd.service.AccountService;
import com.solvd.bin.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.Reader;

public class AccountServiceImpl implements AccountService {
    private static final Logger LOGGER = LogManager.getLogger(AccountServiceImpl.class);

    @Override
    public Account getAccount(long id) {
        Reader reader = null;
        try {
            reader = Resources.getResourceAsReader("mybatis-config.xml");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        SqlSessionFactory sql = new SqlSessionFactoryBuilder().build(reader);
        try (SqlSession session = sql.openSession()) {
            IAccountDAO AccountDAO = session.getMapper(IAccountDAO.class);
            Account account = AccountDAO.getEntityById(id);
            return account;
        }
    }

    @Override
    public void saveAccount(Account account) {
        Reader reader = null;
        try {
            reader = Resources.getResourceAsReader("mybatis-config.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory sql = new SqlSessionFactoryBuilder().build(reader);
        try (SqlSession session = sql.openSession()){
            IAccountDAO AccountDAO = session.getMapper(IAccountDAO.class);
            AccountDAO.saveEntity(account);
        }
    }

    @Override
    public void update(Account account) {
        Reader reader = null;
        try {
            reader = Resources.getResourceAsReader("mybatis-config.xml");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        SqlSessionFactory sql = new SqlSessionFactoryBuilder().build(reader);
        try (SqlSession session = sql.openSession()){
            IAccountDAO AccountDAO = session.getMapper(IAccountDAO.class);
            AccountDAO.updateEntity(account);
        }
    }

    @Override
    public void delete(long id) {
        Reader reader = null;
        try {
            reader = Resources.getResourceAsReader("mybatis-config.xml");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
            SqlSessionFactory sql = new SqlSessionFactoryBuilder().build(reader);
        try (SqlSession session =sql.openSession()){
            IAccountDAO AccountDAO = session.getMapper(IAccountDAO.class);
            AccountDAO.removeEntity(id);
            session.commit();
        }
    }
}
