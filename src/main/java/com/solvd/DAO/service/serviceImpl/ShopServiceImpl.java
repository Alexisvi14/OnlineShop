package com.solvd.DAO.service.serviceImpl;

import com.solvd.DAO.IShopDAO;
import com.solvd.DAO.jdbcMYSQLImpl.ShopDAO;
import com.solvd.DAO.service.ShopService;
import com.solvd.bin.Shop;

public class ShopServiceImpl implements ShopService {
    @Override
    public Shop getShop(long id) {
        IShopDAO shopDAO = new ShopDAO();
        Shop shop = shopDAO.getEntityById(id);
        return shop;
    }

    @Override
    public void saveShop(Shop shop) {
        IShopDAO shopDAO = new ShopDAO();
        shopDAO.saveEntity(shop);
    }

    @Override
    public void update(Shop shop) {
        IShopDAO shopDAO = new ShopDAO();
        shopDAO.updateEntity(shop);
    }

    @Override
    public void delete(long id) {
        IShopDAO shopDAO = new ShopDAO();
        shopDAO.removeEntity(id);
    }
}
