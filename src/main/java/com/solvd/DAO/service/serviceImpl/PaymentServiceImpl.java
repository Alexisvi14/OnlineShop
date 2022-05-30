package com.solvd.DAO.service.serviceImpl;

import com.solvd.DAO.IPaymentDAO;
import com.solvd.DAO.jdbcMYSQLImpl.PaymentDAO;
import com.solvd.DAO.service.PaymentService;
import com.solvd.bin.Payment;

public class PaymentServiceImpl implements PaymentService {

    @Override
    public Payment getPayment(long id) {
        IPaymentDAO paymentDAO = new PaymentDAO();
        Payment payment = paymentDAO.getEntityById(id);
        return payment;
    }

    @Override
    public void savePayment(Payment payment) {
        IPaymentDAO paymentDAO = new PaymentDAO();
        paymentDAO.saveEntity(payment);
    }

    @Override
    public void update(Payment payment) {
        IPaymentDAO paymentDAO = new PaymentDAO();
        paymentDAO.updateEntity(payment);
    }

    @Override
    public void delete(long id) {
        IPaymentDAO paymentDAO = new PaymentDAO();
        paymentDAO.removeEntity(id);
    }
}
