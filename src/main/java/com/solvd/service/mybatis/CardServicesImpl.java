package com.solvd.service.mybatis;

import com.solvd.bin.Card;
import com.solvd.dao.ICardDAO;
import com.solvd.service.CardService;
import org.apache.ibatis.session.SqlSession;

public class CardServicesImpl extends AbstractSession implements CardService {
    @Override
    public Card getCard(long id) {
        SqlSession sqlSession = sqlSession();
        ICardDAO cardDAO = sqlSession.getMapper(ICardDAO.class);
        Card card = cardDAO.getEntityById(id);

        return card;
    }

    @Override
    public void saveCard(Card card) {
        SqlSession sqlSession = sqlSession();
        ICardDAO cardDAO = sqlSession.getMapper(ICardDAO.class);
        cardDAO.saveEntity(card);
        sqlSession.commit();
    }

    @Override
    public void update(Card card) {
        SqlSession sqlSession = sqlSession();
        ICardDAO cardDAO = sqlSession.getMapper(ICardDAO.class);
        cardDAO.updateEntity(card);
        sqlSession.commit();
    }

    @Override
    public void delete(long id) {
        SqlSession sqlSession = sqlSession();
        ICardDAO cardDAO = sqlSession.getMapper(ICardDAO.class);
        cardDAO.removeEntity(id);
        sqlSession.commit();
    }
}
