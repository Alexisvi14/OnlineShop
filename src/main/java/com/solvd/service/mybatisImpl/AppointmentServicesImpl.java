package com.solvd.service.mybatisImpl;

import com.solvd.bin.Appointment;
import com.solvd.dao.IAppointmentDAO;
import com.solvd.service.AppointmentService;
import com.solvd.util.SessionFactory;
import org.apache.ibatis.session.SqlSession;

public class AppointmentServicesImpl implements AppointmentService {
    @Override
    public Appointment getAppointment(long id) {
        try (SqlSession session = SessionFactory.getInstance().getSession()) {
            IAppointmentDAO appointmentDAO = session.getMapper(IAppointmentDAO.class);
            Appointment appointment = appointmentDAO.getEntityById(id);
            return appointment;
        }
    }

    @Override
    public void saveAppointment(Appointment appointment) {
        try (SqlSession session = SessionFactory.getInstance().getSession()) {
            IAppointmentDAO appointmentDAO = session.getMapper(IAppointmentDAO.class);
            appointmentDAO.saveEntity(appointment);
            session.commit();
        }
    }

    @Override
    public void update(Appointment appointment) {
        try (SqlSession session = SessionFactory.getInstance().getSession()) {
            IAppointmentDAO appointmentDAO = session.getMapper(IAppointmentDAO.class);
            appointmentDAO.updateEntity(appointment);
            session.commit();
        }
    }

    @Override
    public void delete(long id) {
        try (SqlSession session = SessionFactory.getInstance().getSession()) {
            IAppointmentDAO appointmentDAO = session.getMapper(IAppointmentDAO.class);
            appointmentDAO.removeEntity(id);
            session.commit();
        }
    }
}
