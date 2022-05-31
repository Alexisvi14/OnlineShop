package com.solvd;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.solvd.DAO.service.AccountService;
import com.solvd.DAO.service.jaxBImpl.EmployeeJaxB;
import com.solvd.DAO.service.serviceImpl.AccountServiceImpl;
import com.solvd.DAO.service.serviceImpl.EmployeeServiceImpl;
import com.solvd.DAO.service.serviceImpl.ShopServiceImpl;
import com.solvd.bin.Account;
import com.solvd.bin.Client;
import com.solvd.bin.Employee;
import com.solvd.bin.Shop;
import com.solvd.util.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;


public class App {
    private final static Logger LOGGER = LogManager.getLogger(App.class);

    public static void main(String[] args) throws IOException, JAXBException {

        //JDBC//
        AccountServiceImpl accountServiceImpl = new AccountServiceImpl();
        //    SELECT ACCOUNT - by id
        Account newAccount = accountServiceImpl.getAccount(1);

        LOGGER.info("The balance of the account with the id 1 is: " + newAccount.getBalance());
        LOGGER.info("The cbu of the account with the id 1 is: " + newAccount.getCbu());

        //    SELECT EMPLOYEE - by id

        EmployeeServiceImpl employeeServiceImpl =new EmployeeServiceImpl();

        Employee employee = employeeServiceImpl.getEmployee(3);
        LOGGER.info("The first name of this employee is: " + employee.getFirstName());
        LOGGER.info("The last name of this employee is: " + employee.getLastName());
        LOGGER.info("The salary of this employee is: " + employee.getSalary());


        //SELECT SHOP - by id
        ShopServiceImpl shopServiceImpl = new ShopServiceImpl();

        Shop shop = shopServiceImpl.getShop(1);
        LOGGER.info("Here is all the information about this shop: " + shop);
        Shop shop1 = shopServiceImpl.getShop(2);
        LOGGER.info("Here is all the information about this shop: " + shop1);



        //INSERT
        newAccount.setBalance(1234);
        newAccount.setCbu(1234562);
        LOGGER.info("Balance: "+ newAccount.getBalance()+ "cbu :" + newAccount.getCbu());

        //JaxB... STILL DOES NOT WORK
        EmployeeJaxB jaxbService = new EmployeeJaxB();
        jaxbService.unmarshall("src/main/resources/employee.xml");

        JAXBContext jaxbContext = JAXBContext.newInstance(Employee.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

        Employee employee1 = (Employee) jaxbUnmarshaller.unmarshal( new File("src/main/resources/employee.xml") );
        LOGGER.info(employee1);

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


