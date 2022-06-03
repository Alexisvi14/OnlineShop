package com.solvd.service.mybatis;

import com.solvd.bin.Shop;
import com.solvd.dao.IShopDAO;
import com.solvd.service.ShopService;
import org.apache.ibatis.session.SqlSession;

public class ShopServicesImpl extends AbstractSession implements ShopService {
    @Override
    public Shop getShop(long id) {
        SqlSession sqlSession = sqlSession();
        IShopDAO shopDAO = sqlSession.getMapper(IShopDAO.class);
        Shop shop = shopDAO.getEntityById(id);

        return shop;
    }

    @Override
    public void saveShop(Shop shop) {
        SqlSession sqlSession = sqlSession();
        IShopDAO shopDAO = sqlSession.getMapper(IShopDAO.class);
        shopDAO.saveEntity(shop);
        sqlSession.commit();
    }

    @Override
    public void update(Shop shop) {
        SqlSession sqlSession = sqlSession();
        IShopDAO shopDAO = sqlSession.getMapper(IShopDAO.class);
        shopDAO.updateEntity(shop);
        sqlSession.commit();
    }

    @Override
    public void delete(long id) {
        SqlSession sqlSession = sqlSession();
        IShopDAO shopDAO = sqlSession.getMapper(IShopDAO.class);
        shopDAO.removeEntity(id);
        sqlSession.commit();
    }
}
