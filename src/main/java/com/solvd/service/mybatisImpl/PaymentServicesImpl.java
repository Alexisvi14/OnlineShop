package com.solvd.service.mybatisImpl;

import com.solvd.bin.Payment;
import com.solvd.dao.IPaymentDAO;
import com.solvd.service.PaymentService;
import com.solvd.util.SessionFactory;
import org.apache.ibatis.session.SqlSession;

public class PaymentServicesImpl implements PaymentService {
    @Override
    public Payment getPayment(long id) {
        try(SqlSession session = SessionFactory.getInstance().getSession()){
            IPaymentDAO paymentDAO = session.getMapper(IPaymentDAO.class);
            Payment payment = paymentDAO.getEntityById(id);
            return payment;
        }
    }

    @Override
    public void savePayment(Payment payment) {
        try(SqlSession session = SessionFactory.getInstance().getSession()){
            IPaymentDAO paymentDAO = session.getMapper(IPaymentDAO.class);
            paymentDAO.saveEntity(payment);
            session.commit();
        }
    }

    @Override
    public void update(Payment payment) {
        try(SqlSession session = SessionFactory.getInstance().getSession()){
            IPaymentDAO paymentDAO = session.getMapper(IPaymentDAO.class);
            paymentDAO.updateEntity(payment);
            session.commit();
        }
    }

    @Override
    public void delete(long id) {
        try(SqlSession session = SessionFactory.getInstance().getSession()){
            IPaymentDAO paymentDAO = session.getMapper(IPaymentDAO.class);
            paymentDAO.removeEntity(id);
            session.commit();
        }
    }
}
