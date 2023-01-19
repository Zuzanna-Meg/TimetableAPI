package com.project.timetable.TimetableAPI.exception;

public class StopNotFound extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public StopNotFound(String message) {
        super(message);
    }
}
