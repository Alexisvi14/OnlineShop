package com.solvd.DAO.service;

import com.solvd.bin.Appointment;

public interface AppointmentService {
    Appointment getAppointment(long id);
    void saveAppointment(Appointment appointment);
    void update(Appointment appointment);
    void delete(long id);
}
