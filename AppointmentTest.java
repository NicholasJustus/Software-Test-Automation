package com.nickjustus.cs320.appointment_service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Test;

class AppointmentTest {

    private Date future() {
        return new Date(System.currentTimeMillis() + 60_000); // +1 min
    }

    private Date past() {
        return new Date(System.currentTimeMillis() - 60_000); // -1 min
    }

    @Test
    void createsValidAppointment() {
        Appointment appt = new Appointment("A1", future(), "Check-up");
        assertEquals("A1", appt.getId());
        assertEquals("Check-up", appt.getDescription());
        assertNotNull(appt.getAppointmentDate());
    }

    @Test
    void idCannotBeNull() {
        assertThrows(IllegalArgumentException.class,
                () -> new Appointment(null, future(), "desc"));
    }

    @Test
    void idCannotBeLongerThan10() {
        assertThrows(IllegalArgumentException.class,
                () -> new Appointment("12345678901", future(), "desc")); // 11 chars
    }

    @Test
    void dateCannotBeNull() {
        assertThrows(IllegalArgumentException.class,
                () -> new Appointment("A1", null, "desc"));
    }

    @Test
    void dateCannotBeInPast() {
        assertThrows(IllegalArgumentException.class,
                () -> new Appointment("A1", past(), "desc"));
    }

    @Test
    void descriptionCannotBeNull() {
        assertThrows(IllegalArgumentException.class,
                () -> new Appointment("A1", future(), null));
    }

    @Test
    void descriptionCannotExceed50() {
        String longDesc = "a".repeat(51);
        assertThrows(IllegalArgumentException.class,
                () -> new Appointment("A1", future(), longDesc));
    }

    @Test
    void canUpdateDateAndDescriptionWithValidation() {
        Appointment appt = new Appointment("A1", future(), "Initial");
        appt.setDescription("Updated");
        appt.setAppointmentDate(new Date(System.currentTimeMillis() + 120_000)); // +2 min
        assertEquals("Updated", appt.getDescription());
        assertTrue(appt.getAppointmentDate().after(new Date()));
    }
}
