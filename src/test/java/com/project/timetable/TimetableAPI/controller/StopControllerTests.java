package com.project.timetable.TimetableAPI.controller;

import com.project.timetable.TimetableAPI.entity.Stop;
import com.project.timetable.TimetableAPI.repository.StopRepository;
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
public class StopControllerTests {

    private static final long ID = 1L;
    private static final String NAME = "Test name";
    private static final String TOWN = "Test town";
    private static final boolean STATION = true;
    private static final Stop NEW_STOP = new Stop(NAME, TOWN, STATION);
    private static final Stop STOP_DATA = new Stop(ID, NAME, TOWN, STATION);

    @Mock
    private StopRepository stopRepository;

    @InjectMocks
    private StopController stopController;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void createStop_ReturnsCreatedStopAndCreatedStatus() {
        ResponseEntity<Stop> response = stopController.createStop(NEW_STOP);

        assertThat(response.getBody()).usingRecursiveComparison().isEqualTo(NEW_STOP);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
    }

    @Test
    public void updateStop_ReturnsUpdatedStopAndOkStatus() {
        when(stopRepository.findById(ID)).thenReturn(Optional.of(STOP_DATA));

        ResponseEntity<Stop> response = stopController.updateStop(ID, NEW_STOP);

        assertThat(response.getBody()).usingRecursiveComparison().isEqualTo(STOP_DATA);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    public void getAllStops_ReturnsListOfStopsAndOkStatus() {
        when(stopRepository.findAll()).thenReturn(List.of(STOP_DATA));

        ResponseEntity<List<Stop>> response = stopController.getAllStops();

        assertThat(response.getBody()).usingRecursiveComparison().isEqualTo(List.of(STOP_DATA));
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    public void getStopById_ReturnsStopAndOkStatus() {
        when(stopRepository.findById(ID)).thenReturn(Optional.of(STOP_DATA));

        ResponseEntity<Stop> response = stopController.getStopById(ID);

        assertThat(response.getBody()).usingRecursiveComparison().isEqualTo(STOP_DATA);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    public void deleteStop_ReturnsNoContentStatus() {
        when(stopRepository.findById(ID)).thenReturn(Optional.of(STOP_DATA));

        ResponseEntity<Stop> response = stopController.deleteStop(ID);

        assertThat(response.getBody()).isNull();
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);
    }
}
