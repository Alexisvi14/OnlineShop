package com.solvd;

import com.solvd.bin.Card;
import com.solvd.service.AccountService;
import com.solvd.service.jackson.AccountJackson;
import com.solvd.service.jaxB.EmployeeJaxB;
import com.solvd.service.JDBCImpl.AccountServiceImpl;
import com.solvd.service.JDBCImpl.EmployeeServiceImpl;
import com.solvd.service.JDBCImpl.ShopServiceImpl;
import com.solvd.bin.Account;
import com.solvd.bin.Employee;
import com.solvd.bin.Shop;
import com.solvd.service.mybatis.AccountServicesImpl;
import com.solvd.service.mybatis.CardServicesImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.List;


public class App {
    private final static Logger LOGGER = LogManager.getLogger(App.class);

    public static void main(String[] args) throws IOException, JAXBException {

        //Everything working//

        //SELECT ACCOUNT - by id
        AccountServiceImpl accountServiceImpl = new AccountServiceImpl();
        Account newAccount = accountServiceImpl.getAccount(1);
        LOGGER.info("The balance of the account with the id 1 is: " + newAccount.getBalance());
        LOGGER.info("The cbu of the account with the id 1 is: " + newAccount.getCbu());

        //SELECT EMPLOYEE - by id
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

        //JAXB - UNMARSHALL
        EmployeeJaxB jaxbService = new EmployeeJaxB();
        Employee employee1 = (Employee) jaxbService.unmarshall("src/main/resources/employee.xml");
        LOGGER.info(employee1);

        //MARSHALL
        EmployeeJaxB employeeJaxB = new EmployeeJaxB();
        Employee employee2 = new Employee();
        employee2.setId(18);
        employee2.setFirstName("Lucia");
        employee2.setLastName("Gomez");
        employee2.setSalary(3200);
        employeeJaxB.marshall(employee2, "src/main/resources/employee2.xml");

        //JACKSON

        AccountJackson accountJackson = new AccountJackson();
        List client = accountJackson.serializedClient("src/main/resources/clients.json");
        LOGGER.info(client);

        //MYBATIS

        AccountServicesImpl accountServices = new AccountServicesImpl();
        Account account2 = accountServices.getAccount(3);
        LOGGER.info(account2);

    }
}


