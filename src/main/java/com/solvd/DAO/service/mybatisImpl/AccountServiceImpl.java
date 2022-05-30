package com.solvd.DAO.service.mybatisImpl;

import com.solvd.DAO.IAccountDAO;
import com.solvd.DAO.service.AccountService;
import com.solvd.bin.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class AccountServiceImpl implements AccountService {
    @Override
    public Account getAccount(long id) {
        Reader e = null;
        try {
            e = Resources.getResourceAsReader("mybatis-config.xml");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        SqlSessionFactory sql = new SqlSessionFactoryBuilder().build(e);
        IAccountDAO AccountDAO = sql.openSession().getMapper(IAccountDAO.class);

        Account account =AccountDAO.getEntityById(id);

        return account;
    }

    @Override
    public void saveAccount(Account account) {

    }

    @Override
    public void update(Account account) {

    }

    @Override
    public void delete(long id) {

    }
}
