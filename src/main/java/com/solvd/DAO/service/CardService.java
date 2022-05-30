package com.solvd.DAO.service;

import com.solvd.bin.Card;

public interface CardService {
    Card getCard(long id);
    void saveCard(Card card);
    void update(Card card);
    void delete(long id);
}
