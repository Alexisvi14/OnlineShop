package com.solvd.service.mybatisImpl;

import com.solvd.bin.Card;
import com.solvd.dao.ICardDAO;
import com.solvd.service.CardService;
import com.solvd.util.SessionFactory;
import org.apache.ibatis.session.SqlSession;

public class CardServicesImpl implements CardService {
    @Override
    public Card getCard(long id) {
        try(SqlSession session = SessionFactory.getInstance().getSession()){
            ICardDAO cardDAO = session.getMapper(ICardDAO.class);
            Card card = cardDAO.getEntityById(id);
            return card;
        }
    }

    @Override
    public void saveCard(Card card) {
        try(SqlSession session = SessionFactory.getInstance().getSession()){
            ICardDAO cardDAO = session.getMapper(ICardDAO.class);
            cardDAO.saveEntity(card);
            session.commit();
        }
    }

    @Override
    public void update(Card card) {
        try(SqlSession session = SessionFactory.getInstance().getSession()){
            ICardDAO cardDAO = session.getMapper(ICardDAO.class);
            cardDAO.updateEntity(card);
            session.commit();
        }
    }

    @Override
    public void delete(long id) {
        try(SqlSession session = SessionFactory.getInstance().getSession()){
            ICardDAO cardDAO = session.getMapper(ICardDAO.class);
            cardDAO.removeEntity(id);
            session.commit();
        }
    }
}