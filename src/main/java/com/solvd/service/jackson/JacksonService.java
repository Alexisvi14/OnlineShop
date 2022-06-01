package com.solvd.service.jackson;

import com.solvd.bin.Client;

import java.util.List;

public interface JacksonService {
    List <Client> serializedClient(String path);
}
