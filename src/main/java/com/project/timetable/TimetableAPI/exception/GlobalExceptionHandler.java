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

    @ExceptionHandler(StopNotFound.class)
    public ResponseEntity<ErrorMessage> stopNotFound(Exception e, WebRequest request){
        ErrorMessage errors = new ErrorMessage(404, new Date(), e.getMessage(), "Stop Not Found");

        return new ResponseEntity<>(errors, HttpStatus.NOT_FOUND);
    }

//    @ExceptionHandler(RouteNotFound.class)
//    public ResponseEntity<ErrorMessage> routeNotFound(Exception e, WebRequest request){
//        ErrorMessage errors = new ErrorMessage(404, new Date(), e.getMessage(), "Route Not Found");
//
//        return new ResponseEntity<>(errors, HttpStatus.NOT_FOUND);
//    }

    @ExceptionHandler(DeleteDenied.class)
    public ResponseEntity<ErrorMessage> deleteDenied(Exception e, WebRequest request){
        ErrorMessage errors = new ErrorMessage(405, new Date(), e.getMessage(), "Deletion Request Denied");

        return new ResponseEntity<>(errors, HttpStatus.METHOD_NOT_ALLOWED);
    }
}
