package com.project.timetable.TimetableAPI.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BusNotFound.class)
    public ResponseEntity<ErrorMessage> busNotFound(Exception e, WebRequest request){
        ErrorMessage errors = new ErrorMessage(404, new Date(), e.getMessage(), "Bus Not Found");

        return new ResponseEntity<>(errors, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DriverNotFound.class)
    public ResponseEntity<ErrorMessage> driverNotFound(Exception e, WebRequest request){
        ErrorMessage errors = new ErrorMessage(404, new Date(), e.getMessage(), "Driver Not Found");

        return new ResponseEntity<>(errors, HttpStatus.NOT_FOUND);
    }
}
