package com.nickjustus.cs320.appointment_service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AppointmentServiceTest {

    private AppointmentService service;

    private Date future() {
        return new Date(System.currentTimeMillis() + 60_000);
    }

    @BeforeEach
    void setUp() {
        service = new AppointmentService();
    }

    @Test
    void canAddAppointmentsWithUniqueIds() {
        service.addAppointment(new Appointment("A1", future(), "Dentist"));
        service.addAppointment(new Appointment("A2", future(), "Doctor"));
        assertEquals(2, service.size());
        assertNotNull(service.getAppointment("A1"));
        assertNotNull(service.getAppointment("A2"));
    }

    @Test
    void duplicateIdNotAllowed() {
        service.addAppointment(new Appointment("A1", future(), "Dentist"));
        assertThrows(IllegalArgumentException.class,
                () -> service.addAppointment(new Appointment("A1", future(), "Another")));
    }

    @Test
    void deleteByIdRemovesAppointment() {
        service.addAppointment(new Appointment("A1", future(), "Dentist"));
        assertEquals(1, service.size());
        service.deleteAppointment("A1");
        assertEquals(0, service.size());
        assertNull(service.getAppointment("A1"));
    }

    @Test
    void deleteUnknownIdThrows() {
        assertThrows(IllegalArgumentException.class,
                () -> service.deleteAppointment("ZZZ"));
    }
}
