package com.solvd.service.jackson;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.solvd.bin.Client;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class AccountJackson implements JacksonService{
    private static final Logger LOGGER = LogManager.getLogger(AccountJackson.class);

    @Override
    public List<Client> serializedClient(String path) {
        ObjectMapper om = new ObjectMapper();
        try{
            JavaType type = om.getTypeFactory().constructCollectionType(List.class, Client.class);
            return om.readValue(new File(path), type);
        } catch (IOException e) {
            e.printStackTrace();
            LOGGER.info("There was an error while des serializing the client", e);
            throw new RuntimeException(e);
        }
    }
}
