package com.solvd.service.mybatisImpl;

import com.solvd.bin.Shop;
import com.solvd.dao.IShopDAO;
import com.solvd.service.ShopService;
import com.solvd.util.SessionFactory;
import org.apache.ibatis.session.SqlSession;

public class ShopServicesImpl implements ShopService {
    @Override
    public Shop getShop(long id) {
        try(SqlSession session = SessionFactory.getInstance().getSession()){
            IShopDAO shopDAO = session.getMapper(IShopDAO.class);
            Shop shop = shopDAO.getEntityById(id);
            return shop;
        }
    }

    @Override
    public void saveShop(Shop shop) {
        try(SqlSession session = SessionFactory.getInstance().getSession()){
            IShopDAO shopDAO = session.getMapper(IShopDAO.class);
            shopDAO.saveEntity(shop);
            session.commit();
        }
    }

    @Override
    public void update(Shop shop) {
        try(SqlSession session = SessionFactory.getInstance().getSession()){
            IShopDAO shopDAO = session.getMapper(IShopDAO.class);
            shopDAO.updateEntity(shop);
            session.commit();
        }
    }

    @Override
    public void delete(long id) {
        try (SqlSession session = SessionFactory.getInstance().getSession()) {
            IShopDAO shopDAO = session.getMapper(IShopDAO.class);
            shopDAO.removeEntity(id);
            session.commit();
        }
    }
}
