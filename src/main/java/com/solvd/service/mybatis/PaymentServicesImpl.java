package com.solvd.service.mybatis;

import com.solvd.bin.Payment;
import com.solvd.dao.IPaymentDAO;
import com.solvd.service.PaymentService;
import org.apache.ibatis.session.SqlSession;

public class PaymentServicesImpl extends AbstractSession implements PaymentService {
    @Override
    public Payment getPayment(long id) {
        SqlSession sqlSession = sqlSession();
        IPaymentDAO paymentDAO = sqlSession.getMapper(IPaymentDAO.class);
        Payment payment = paymentDAO.getEntityById(id);

        return payment;
    }

    @Override
    public void savePayment(Payment payment) {
        SqlSession sqlSession = sqlSession();
        IPaymentDAO paymentDAO = sqlSession.getMapper(IPaymentDAO.class);
        paymentDAO.saveEntity(payment);
        sqlSession.commit();
    }

    @Override
    public void update(Payment payment) {
        SqlSession sqlSession = sqlSession();
        IPaymentDAO paymentDAO = sqlSession.getMapper(IPaymentDAO.class);
        paymentDAO.updateEntity(payment);
        sqlSession.commit();
    }

    @Override
    public void delete(long id) {
        SqlSession sqlSession = sqlSession();
        IPaymentDAO paymentDAO = sqlSession.getMapper(IPaymentDAO.class);
        paymentDAO.removeEntity(id);
        sqlSession.commit();
    }
}
