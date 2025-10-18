package com.nickjustus.cs320.appointment_service;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * In-memory appointment service.
 * - addAppointment: adds if id is unique
 * - deleteAppointment: deletes by id
 */
public class AppointmentService {

    private final Map<String, Appointment> store = new HashMap<>();

    public void addAppointment(Appointment appointment) {
        if (appointment == null) {
            throw new IllegalArgumentException("Appointment cannot be null");
        }
        String id = appointment.getId();
        if (store.containsKey(id)) {
            throw new IllegalArgumentException("Duplicate appointment id: " + id);
        }
        store.put(id, appointment);
    }

    public void deleteAppointment(String id) {
        if (id == null || !store.containsKey(id)) {
            throw new IllegalArgumentException("No appointment with id: " + id);
        }
        store.remove(id);
    }

    // Small helpers for tests/debugging
    public Appointment getAppointment(String id) {
        return store.get(id);
    }

    public int size() {
        return store.size();
    }

    public Map<String, Appointment> snapshot() {
        return Collections.unmodifiableMap(store);
    }
}
