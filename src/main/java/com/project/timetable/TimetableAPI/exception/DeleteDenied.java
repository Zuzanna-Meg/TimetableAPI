package com.project.timetable.TimetableAPI.exception;

public class DeleteDenied extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public DeleteDenied(String message) {
        super(message);
    }
}
