package com.solvd.DAO.service;

import com.solvd.bin.Account;

public interface AccountService {
    Account getAccount(long id);
    void saveAccount(Account account);
    void update(Account account);
    void delete(long id);
}
