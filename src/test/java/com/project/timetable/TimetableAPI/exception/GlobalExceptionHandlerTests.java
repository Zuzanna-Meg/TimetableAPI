package com.project.timetable.TimetableAPI.exception;

import org.junit.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.WebRequest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class GlobalExceptionHandlerTests {

    @Mock
    WebRequest mockWebRequest;

    @Test
    public void busNotFound_ReturnsCorrectHttpResponse() {
        GlobalExceptionHandler exceptionHandler = new GlobalExceptionHandler();

        ResponseEntity<ErrorMessage> response = exceptionHandler.busNotFound(new Exception(), mockWebRequest);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
    }

    @Test
    public void driverNotFound_ReturnsCorrectHttpResponse() {
        GlobalExceptionHandler exceptionHandler = new GlobalExceptionHandler();

        ResponseEntity<ErrorMessage> response = exceptionHandler.driverNotFound(new Exception(), mockWebRequest);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
    }

    @Test
    public void stopNotFound_ReturnsCorrectHttpResponse() {
        GlobalExceptionHandler exceptionHandler = new GlobalExceptionHandler();

        ResponseEntity<ErrorMessage> response = exceptionHandler.stopNotFound(new Exception(), mockWebRequest);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
    }
}
