package com.project.timetable.TimetableAPI.controller;

import com.project.timetable.TimetableAPI.entity.Bus;
import com.project.timetable.TimetableAPI.exception.BusNotFound;
import com.project.timetable.TimetableAPI.repository.BusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/bus")
public class BusController {

    @Autowired
    BusRepository busRepository;

    //Create bus
    @PostMapping
    public ResponseEntity<Bus> createBus(@RequestBody Bus bus) {
        Bus newBus = new Bus(bus.getSeats(), bus.getType(), bus.getAccess());
        busRepository.save(newBus);
        return new ResponseEntity<>(newBus, HttpStatus.CREATED);
    }

    //amend bus
    @PutMapping("/{id}")
    public ResponseEntity<Bus> updateBus(@PathVariable("id") Long id, @RequestBody Bus newbus) {
        Optional<Bus> busData = busRepository.findById(id);
        if (busData.isPresent()) {
            Bus bus = busData.get();
            bus.setSeats(newbus.getSeats());
            bus.setType(newbus.getType());
            bus.setAccess(newbus.getAccess());
            busRepository.save(bus);
            return new ResponseEntity<>(bus, HttpStatus.OK);
        } else {
            throw new BusNotFound("Invalid Bus Id");
        }
    }

    //get all
    @GetMapping
    public ResponseEntity<List<Bus>> getAllBuses() {
        List<Bus> buses = new ArrayList<>();
        busRepository.findAll().forEach(buses::add);
        return new ResponseEntity<>(buses, HttpStatus.OK);
    }

    //get by id
    @GetMapping("/{id}")
    public ResponseEntity<Bus> getBusById (@PathVariable("id") Long id) {

        Optional<Bus> busData = busRepository.findById(id);
        if (busData.isPresent()) {
            return new ResponseEntity<>(busData.get(), HttpStatus.OK);
        } else {
            throw new BusNotFound("Invalid Bus Id");
        }
    }

    //delete bus by id
    @DeleteMapping("/{id}")
    public ResponseEntity<Bus> deleteBus (@PathVariable("id") Long id) {

        Optional<Bus> busData = busRepository.findById(id);
        if (busData.isPresent()) {
            busRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            throw new BusNotFound("Invalid Bus Id");
        }
    }
}
















