package com.solvd.DAO.service.serviceImpl;

import com.solvd.DAO.service.JaxbService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class JaxbServiceImpl implements JaxbService {
    private static final Logger LOGGER = LogManager.getLogger(JaxbServiceImpl.class);

    public void marshall(Object object, String xmlResultPath) {
        JAXBContext jaxbContext;
        try {
            jaxbContext = JAXBContext.newInstance(this.getClass());
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.marshal(object, new File(xmlResultPath));
        } catch (JAXBException e) {
            LOGGER.error("There was an error with jaxb library", e);
        }
    }
    public Object unmarshall(String xmlFilePath) {
        File xmlFile = new File(xmlFilePath);
        JAXBContext jaxbContext;
        try {
            jaxbContext = JAXBContext.newInstance(Object.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            return unmarshaller.unmarshal(xmlFile);
        } catch (JAXBException e) {
            LOGGER.error("There was an error with jaxb library", e);
        }
        return null;
    }
}