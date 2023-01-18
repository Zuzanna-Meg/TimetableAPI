package com.project.timetable.TimetableAPI.exception;

public class BusNotFound extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public BusNotFound(String message) {
        super(message);
    }
}
