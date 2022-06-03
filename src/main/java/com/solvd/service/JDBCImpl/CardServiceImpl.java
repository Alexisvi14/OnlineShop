package com.solvd.service.JDBCImpl;

import com.solvd.dao.ICardDAO;
import com.solvd.dao.jdbcMYSQLImpl.CardDAO;
import com.solvd.service.CardService;
import com.solvd.bin.Card;

public class CardServiceImpl implements CardService {

    @Override
    public Card getCard(long id) {
        ICardDAO cardDAO = new CardDAO();
        Card card = cardDAO.getEntityById(id);
        return card;
    }

    @Override
    public void saveCard(Card card) {
        ICardDAO cardDAO = new CardDAO();

    }

    @Override
    public void update(Card card) {

    }

    @Override
    public void delete(long id) {

    }
}
