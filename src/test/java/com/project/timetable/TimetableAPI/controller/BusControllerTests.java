package com.project.timetable.TimetableAPI.controller;

import com.project.timetable.TimetableAPI.entity.Bus;
import com.project.timetable.TimetableAPI.repository.BusRepository;
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
public class BusControllerTests {

    private static final long ID = 1L;
    private static final long SEATS = 5L;
    private static final String TYPE = "Test type";
    private static final String ACCESS = "Test access";
    private static final Bus NEW_BUS = new Bus(SEATS, TYPE, ACCESS);
    private static final Bus BUS_DATA = new Bus(ID, SEATS, TYPE, ACCESS);

    @Mock
    private BusRepository busRepository;

    @InjectMocks
    private BusController busController;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void createBus_ReturnsCreatedBusAndCreatedStatus() {
        ResponseEntity<Bus> response = busController.createBus(NEW_BUS);

        assertThat(response.getBody()).usingRecursiveComparison().isEqualTo(NEW_BUS);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
    }

    @Test
    public void updateBus_ReturnsUpdatedBusAndOkStatus() {
        when(busRepository.findById(ID)).thenReturn(Optional.of(BUS_DATA));

        ResponseEntity<Bus> response = busController.updateBus(ID, NEW_BUS);

        assertThat(response.getBody()).usingRecursiveComparison().isEqualTo(BUS_DATA);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    public void getAllBuses_ReturnsListOfBusesAndOkStatus() {
        when(busRepository.findAll()).thenReturn(List.of(BUS_DATA));

        ResponseEntity<List<Bus>> response = busController.getAllBuses();

        assertThat(response.getBody()).usingRecursiveComparison().isEqualTo(List.of(BUS_DATA));
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    public void getBusById_ReturnsBusAndOkStatus() {
        when(busRepository.findById(ID)).thenReturn(Optional.of(BUS_DATA));

        ResponseEntity<Bus> response = busController.getBusById(ID);

        assertThat(response.getBody()).usingRecursiveComparison().isEqualTo(BUS_DATA);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    public void deleteBus_ReturnsNoContentStatus() {
        when(busRepository.findById(ID)).thenReturn(Optional.of(BUS_DATA));

        ResponseEntity<Bus> response = busController.deleteBus(ID);

        assertThat(response.getBody()).isNull();
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);
    }
}
