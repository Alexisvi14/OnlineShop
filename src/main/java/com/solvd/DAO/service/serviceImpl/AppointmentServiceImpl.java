package com.solvd.DAO.service.serviceImpl;

import com.solvd.DAO.IAppointmentDAO;
import com.solvd.DAO.jdbcMYSQLImpl.AppointmentDAO;
import com.solvd.DAO.service.AppointmentService;
import com.solvd.bin.Appointment;

public class AppointmentServiceImpl implements AppointmentService {

    @Override
    public Appointment getAppointment(long id) {
        IAppointmentDAO appointmentDAO = new AppointmentDAO();
        Appointment appointment = appointmentDAO.getEntityById(id);
        return appointment;
    }

    @Override
    public void saveAppointment(Appointment appointment) {
        IAppointmentDAO appointmentDAO = new AppointmentDAO();
        appointmentDAO.saveEntity(appointment);
    }

    @Override
    public void update(Appointment appointment) {
        IAppointmentDAO appointmentDAO = new AppointmentDAO();
        appointmentDAO.updateEntity(appointment);
    }

    @Override
    public void delete(long id) {
        IAppointmentDAO appointmentDAO = new AppointmentDAO();
        appointmentDAO.removeEntity(id);
    }
}
