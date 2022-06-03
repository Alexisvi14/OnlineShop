package com.solvd.service.mybatis;

import com.solvd.bin.Appointment;
import com.solvd.dao.IAppointmentDAO;
import com.solvd.service.AppointmentService;
import org.apache.ibatis.session.SqlSession;

public class AppointmentServicesImpl extends AbstractSession implements AppointmentService {
    @Override
    public Appointment getAppointment(long id) {
        SqlSession sqlSession = sqlSession();
        IAppointmentDAO appointmentDAO = sqlSession.getMapper(IAppointmentDAO.class);
        Appointment appointment = appointmentDAO.getEntityById(id);

        return appointment;
    }

    @Override
    public void saveAppointment(Appointment appointment) {
        SqlSession sqlSession = sqlSession();
        IAppointmentDAO appointmentDAO = sqlSession.getMapper(IAppointmentDAO.class);
        appointmentDAO.saveEntity(appointment);
        sqlSession.commit();
    }

    @Override
    public void update(Appointment appointment) {
        SqlSession sqlSession = sqlSession();
        IAppointmentDAO appointmentDAO = sqlSession.getMapper(IAppointmentDAO.class);
        appointmentDAO.updateEntity(appointment);
        sqlSession.commit();
    }

    @Override
    public void delete(long id) {
        SqlSession sqlSession = sqlSession();
        IAppointmentDAO appointmentDAO = sqlSession.getMapper(IAppointmentDAO.class);
        appointmentDAO.removeEntity(id);
        sqlSession.commit();
    }
}
