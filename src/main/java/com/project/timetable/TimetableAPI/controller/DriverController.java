package com.project.timetable.TimetableAPI.controller;

import com.project.timetable.TimetableAPI.entity.Driver;
import com.project.timetable.TimetableAPI.exception.DriverNotFound;
import com.project.timetable.TimetableAPI.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/driver")
public class DriverController {

    @Autowired
    DriverRepository driverRepository;

    //Create Driver
    @PostMapping
    public ResponseEntity<Driver> createDriver(@RequestBody Driver Driver) {
        Driver newDriver = new Driver(Driver.getName(), Driver.getMobile());
        driverRepository.save(newDriver);
        return new ResponseEntity<>(newDriver, HttpStatus.CREATED);
    }

    //amend Driver
    @PutMapping("/{id}")
    public ResponseEntity<Driver> updateDriver(@PathVariable("id") Long id, @RequestBody Driver newDriver) {
        Optional<Driver> driverdata = driverRepository.findById(id);
        if (driverdata.isPresent()) {
            Driver driver = driverdata.get();
            driver.setName(newDriver.getName());
            driver.setMobile(newDriver.getMobile());
            return new ResponseEntity<>(driverRepository.save(driver), HttpStatus.OK);
        } else {
            throw new DriverNotFound("Invalid Driver Id");
        }
    }

    //get all
    @GetMapping
    public ResponseEntity<List<Driver>> getAllDrivers() {
        List<Driver> drivers = new ArrayList<Driver>();
        driverRepository.findAll().forEach(drivers::add);
        return new ResponseEntity<>(drivers, HttpStatus.OK);
    }

    //get by id
    @GetMapping("/{id}")
    public ResponseEntity<Driver> getDriverById (@PathVariable("id") Long id) {

        Optional<Driver> driverdata = driverRepository.findById(id);
        if (driverdata.isPresent()) {
            return new ResponseEntity<>(driverdata.get(), HttpStatus.OK);
        } else {
            throw new DriverNotFound("Invalid Driver Id");
        }
    }

    //delete Driver by id
    @DeleteMapping("/{id}")
    public ResponseEntity<Driver> deleteDriver (@PathVariable("id") Long id) {

        Optional<Driver> driverdata = driverRepository.findById(id);
        if (driverdata.isPresent()) {
            driverRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            throw new DriverNotFound("Invalid Driver Id");
        }
    }
}
















