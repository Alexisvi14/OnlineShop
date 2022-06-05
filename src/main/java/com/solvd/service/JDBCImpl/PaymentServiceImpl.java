package com.solvd.service.jdbcImpl;

import com.solvd.dao.IPaymentDAO;
import com.solvd.dao.Impl.PaymentDAO;
import com.solvd.service.PaymentService;
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
