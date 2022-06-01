package com.solvd.service.jaxB;


public interface JaxbService <T>{
    Object unmarshall(String xmlFilePath);
    void marshall(T object, String xmlResultPath);
}
