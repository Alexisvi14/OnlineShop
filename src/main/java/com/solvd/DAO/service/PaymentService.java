package com.solvd.DAO.service;

import com.solvd.bin.Payment;

public interface PaymentService {
    Payment getPayment(long id);
    void savePayment(Payment payment);
    void update(Payment payment);
    void delete(long id);
}
