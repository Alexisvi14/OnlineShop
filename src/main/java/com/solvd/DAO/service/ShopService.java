package com.solvd.DAO.service;

import com.solvd.bin.Payment;
import com.solvd.bin.Shop;

public interface ShopService {
    Shop getShop(long id);
    void saveShop(Shop shop);
    void update(Shop shop);
    void delete(long id);
}
