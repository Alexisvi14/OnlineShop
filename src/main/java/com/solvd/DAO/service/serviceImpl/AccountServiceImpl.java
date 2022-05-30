package com.solvd.DAO.service.serviceImpl;

import com.solvd.DAO.IAccountDAO;
import com.solvd.DAO.jdbcMYSQLImpl.AccountDAO;
import com.solvd.DAO.service.AccountService;
import com.solvd.bin.Account;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;

public class AccountServiceImpl implements AccountService {
    private final static Logger LOGGER = LogManager.getLogger(AccountServiceImpl.class);


    @Override
    public Account getAccount(long id) {
        IAccountDAO accountDAO = new AccountDAO();
        Account account = accountDAO.getEntityById(id);
        return account;
    }

    @Override
    public void saveAccount(Account account) {
        IAccountDAO accountDAO = new AccountDAO();
        accountDAO.saveEntity(account);
    }

    @Override
    public void update(Account account) {
        IAccountDAO accountDAO = new AccountDAO();
        accountDAO.updateEntity(account);
    }

    @Override
    public void delete(long id) {
        IAccountDAO accountDAO = new AccountDAO();
        accountDAO.removeEntity(id);
    }
}
