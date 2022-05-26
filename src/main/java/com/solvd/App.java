package com.solvd;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.solvd.bin.Client;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;;
import java.util.List;

public class App {
    private final static Logger LOGGER = LogManager.getLogger(App.class);

    public static void main(String[] args) {
        ObjectMapper om = new ObjectMapper();

        try {
            JavaType type = om.getTypeFactory().constructCollectionType(List.class, Client.class);
            LOGGER.info("...");

            Client clients = om.readValue(new File("src/main/resources/clients.json"), type);
            LOGGER.info(clients);


        } catch (Exception e){
            e.printStackTrace();
        }
        //Here we have to use just services.
    }
}
