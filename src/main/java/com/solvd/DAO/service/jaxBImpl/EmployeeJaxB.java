package com.solvd.DAO.service.jaxBImpl;

import com.solvd.DAO.service.JaxbService;
import com.solvd.DAO.service.serviceImpl.JaxbServiceImpl;
import com.solvd.bin.Employee;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class EmployeeJaxB {
    private static final Logger LOGGER = LogManager.getLogger(EmployeeJaxB.class);

    public static void unmarshall(String xmlFilePath) {
        File xmlFile = new File(xmlFilePath);
        JAXBContext jaxbContext;
        try {
            jaxbContext = JAXBContext.newInstance(Employee.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        } catch (JAXBException e) {
            LOGGER.error("There was an error with jaxb library", e);
        }
    }
}
