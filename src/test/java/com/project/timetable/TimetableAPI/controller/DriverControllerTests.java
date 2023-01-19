package com.project.timetable.TimetableAPI.controller;

import com.project.timetable.TimetableAPI.entity.Driver;
import com.project.timetable.TimetableAPI.repository.DriverRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@SpringBootTest
public class DriverControllerTests {

    private static final long ID = 1L;
    private static final String NAME = "Test name";
    private static final String MOBILE = "Test mobile";
    private static final Driver NEW_DRIVER = new Driver(NAME, MOBILE);
    private static final Driver DRIVER_DATA = new Driver(ID, NAME, MOBILE);

    @Mock
    private DriverRepository driverRepository;

    @InjectMocks
    private DriverController driverController;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void createDriver_ReturnsCreatedDriverAndCreatedStatus() {
        ResponseEntity<Driver> response = driverController.createDriver(NEW_DRIVER);

        assertThat(response.getBody()).usingRecursiveComparison().isEqualTo(NEW_DRIVER);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
    }

    @Test
    public void updateDriver_ReturnsUpdatedDriverAndOkStatus() {
        when(driverRepository.findById(ID)).thenReturn(Optional.of(DRIVER_DATA));

        ResponseEntity<Driver> response = driverController.updateDriver(ID, NEW_DRIVER);

        assertThat(response.getBody()).usingRecursiveComparison().isEqualTo(DRIVER_DATA);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    public void getAllDrivers_ReturnsListOfDriversAndOkStatus() {
        when(driverRepository.findAll()).thenReturn(List.of(DRIVER_DATA));

        ResponseEntity<List<Driver>> response = driverController.getAllDrivers();

        assertThat(response.getBody()).usingRecursiveComparison().isEqualTo(List.of(DRIVER_DATA));
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    public void getDriverById_ReturnsDriverAndOkStatus() {
        when(driverRepository.findById(ID)).thenReturn(Optional.of(DRIVER_DATA));

        ResponseEntity<Driver> response = driverController.getDriverById(ID);

        assertThat(response.getBody()).usingRecursiveComparison().isEqualTo(DRIVER_DATA);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    public void deleteDriver_ReturnsNoContentStatus() {
        when(driverRepository.findById(ID)).thenReturn(Optional.of(DRIVER_DATA));

        ResponseEntity<Driver> response = driverController.deleteDriver(ID);

        assertThat(response.getBody()).isNull();
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);
    }
}
