package com.solvd;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.solvd.DAO.IAccountDAO;
import com.solvd.DAO.service.AccountService;
import com.solvd.DAO.service.serviceImpl.AccountServiceImpl;
import com.solvd.DAO.service.serviceImpl.JaxbServiceImpl;
import com.solvd.bin.Account;
import com.solvd.bin.Client;
import com.solvd.util.ConnectionPool;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;;
import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.util.List;

public class App {
    private final static Logger LOGGER = LogManager.getLogger(App.class);

    public static void main(String[] args) throws IOException {

        //JSON//
        ObjectMapper om = new ObjectMapper();
        LOGGER.info("Object mapper created");
        try {
            JavaType type = om.getTypeFactory().constructCollectionType(List.class, Client.class);
            LOGGER.info("...");

            List clients = om.readValue(new File("src/main/resources/clients.json"), type);
            LOGGER.info(clients);

        } catch (Exception e) {
            e.printStackTrace();
        }
        //JDBC//
        AccountServiceImpl accountServiceImpl = new AccountServiceImpl();
        //    SELECT - by id
        Account newAccount = accountServiceImpl.getAccount(1);
        LOGGER.info("The id of the account with the id 1 is: " + newAccount.getId());
        LOGGER.info("The balance of the account with the id 1 is: " + newAccount.getBalance());
        LOGGER.info("The cbu of the account with the id 1 is: " + newAccount.getCbu());

        //JaxB... STILL DOES NOT WORK
        JaxbServiceImpl jaxbService = new JaxbServiceImpl();
        jaxbService.unmarshall("src/main/resources/employee.xml");


        //Mybatis

        Connection c = ConnectionPool.getInstance().getConnection();
        AccountService accountService = new AccountServiceImpl();
        LOGGER.info(accountService.getAccount(2).toString());


        try {
            AccountServiceImpl accountMyBatis = new AccountServiceImpl();
            LOGGER.error(accountMyBatis.getAccount(4).toString());
        } catch (Exception e) {
            LOGGER.error(e);
        }
    }
}


