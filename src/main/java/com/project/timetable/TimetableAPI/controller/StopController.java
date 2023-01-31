package com.project.timetable.TimetableAPI.controller;


//import com.project.timetable.TimetableAPI.entity.Route;
import com.project.timetable.TimetableAPI.entity.Stop;
import com.project.timetable.TimetableAPI.exception.DeleteDenied;
import com.project.timetable.TimetableAPI.exception.StopNotFound;
//import com.project.timetable.TimetableAPI.repository.RouteRepository;
import com.project.timetable.TimetableAPI.repository.StopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/stop")
public class StopController {

    @Autowired
    StopRepository stopRepository;
//    @Autowired
//    RouteRepository routeRepository;

    @PostMapping
    public ResponseEntity<Stop> createStop(@RequestBody Stop stop) {
        Stop newStop = new Stop(stop.getName(), stop.getTown(), stop.isStation());
        stopRepository.save(newStop);
        return new ResponseEntity<>(newStop, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Stop> updateStop(@PathVariable("id") Long id, @RequestBody Stop newStop) {
        Optional<Stop> stopData = stopRepository.findById(id);
        if(stopData.isPresent()) {
            Stop stop = stopData.get();
            stop.setName(newStop.getName());
            stop.setTown(newStop.getTown());
            stop.setStation(newStop.isStation());
            stopRepository.save(stop);
            return new ResponseEntity<>(stop, HttpStatus.OK);
        } else {
            throw new StopNotFound("Invalid Stop Id");
        }
    }

    @GetMapping
    public ResponseEntity<List<Stop>> getAllStops() {
        List<Stop> stops = new ArrayList<>();
        stopRepository.findAll().forEach(stops::add);
        return new ResponseEntity<>(stops, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Stop> getStopById(@PathVariable("id") Long id) {
        Optional<Stop> stopData = stopRepository.findById(id);
        if (stopData.isPresent()) {
            return new ResponseEntity<>(stopData.get(), HttpStatus.OK);
        } else {
            throw new StopNotFound("Invalid Stop Id");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Stop> deleteStop(@PathVariable("id") Long id) {

        Optional<Stop> stopData = stopRepository.findById(id);
        if (stopData.isPresent()) {
            if (stopCurrentlyInUse(id)){
                throw new DeleteDenied("Stop Currently In Use");
            }
            stopRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            throw new StopNotFound("Invalid Stop Id");
        }
    }

    private boolean stopCurrentlyInUse(Long id){
//        List<Route> routes = new ArrayList<>();
//        routeRepository.findAll().forEach(routes::add);
//        for (Route route : routes){
//            if (route.getDepartureStop().getId().equals(id)
//                    || route.getDestinationStop().getId().equals(id)) {
//                return true;
//            }
//        }
        return false;
    }
}
