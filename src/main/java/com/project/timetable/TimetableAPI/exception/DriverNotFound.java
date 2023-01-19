package com.project.timetable.TimetableAPI.exception;

public class DriverNotFound extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public DriverNotFound(String message) {
        super(message);
    }
}
