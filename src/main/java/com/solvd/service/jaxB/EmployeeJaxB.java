package com.solvd.service.jaxB;

import com.solvd.bin.Employee;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class EmployeeJaxB implements JaxbService<Employee> {
    private static final Logger LOGGER = LogManager.getLogger(EmployeeJaxB.class);

    public Employee unmarshall(String xmlFilePath) {
        File xmlFile = new File(xmlFilePath);
        JAXBContext jaxbContext;
        try {
            jaxbContext = JAXBContext.newInstance(Employee.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            return (Employee) unmarshaller.unmarshal(xmlFile);
        } catch (JAXBException e) {
            LOGGER.error("There was an error with jaxb library", e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public void marshall(Employee employee, String xmlResultPath) {
        JAXBContext jaxbContext;
        try {
            jaxbContext = JAXBContext.newInstance(Employee.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.marshal(employee, new File(xmlResultPath));
        } catch (JAXBException e) {
            LOGGER.error("There was an error with jaxb library", e);
        }
    }
}
