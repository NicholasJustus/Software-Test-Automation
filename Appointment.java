package com.nickjustus.cs320.appointment_service;

import java.util.Date;
import java.util.Objects;

/**
 * Appointment domain object.
 * - id: required, non-null, <= 10 chars, not updatable
 * - appointmentDate: required, non-null, not in the past
 * - description: required, non-null, <= 50 chars
 */
public class Appointment {

    public static final int MAX_ID_LENGTH = 10;
    public static final int MAX_DESCRIPTION_LENGTH = 50;

    private final String id;
    private Date appointmentDate;
    private String description;

    public Appointment(String id, Date appointmentDate, String description) {
        validateId(id);
        this.id = id;
        setAppointmentDate(appointmentDate);
        setDescription(description);
    }

    private static void validateId(String id) {
        if (id == null || id.length() > MAX_ID_LENGTH) {
            throw new IllegalArgumentException("Invalid id");
        }
    }

    private static void validateDescription(String description) {
        if (description == null || description.length() > MAX_DESCRIPTION_LENGTH) {
            throw new IllegalArgumentException("Invalid description");
        }
    }

    private static void validateDate(Date date) {
        if (date == null) {
            throw new IllegalArgumentException("Date cannot be null");
        }
        if (date.before(new Date())) {
            throw new IllegalArgumentException("Date cannot be in the past");
        }
    }

    // Defensive copy
    private static Date copy(Date d) {
        return new Date(d.getTime());
    }

    public String getId() {
        return id;
    }

    public Date getAppointmentDate() {
        return appointmentDate == null ? null : copy(appointmentDate);
    }

    public String getDescription() {
        return description;
    }

    public void setAppointmentDate(Date appointmentDate) {
        validateDate(appointmentDate);
        this.appointmentDate = copy(appointmentDate);
    }

    public void setDescription(String description) {
        validateDescription(description);
        this.description = description;
    }

    // optional, helpful for service usage and debugging
    @Override
    public String toString() {
        return "Appointment{" +
                "id='" + id + '\'' +
                ", date=" + appointmentDate +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Appointment that)) return false;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
