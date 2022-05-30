package com.solvd.DAO.service.serviceImpl;

import com.solvd.DAO.ICardDAO;
import com.solvd.DAO.jdbcMYSQLImpl.CardDAO;
import com.solvd.DAO.service.CardService;
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
