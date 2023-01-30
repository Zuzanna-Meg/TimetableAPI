package com.project.timetable.TimetableAPI.controller;

import com.project.timetable.TimetableAPI.entity.Route;
import com.project.timetable.TimetableAPI.entity.RouteDto;
import com.project.timetable.TimetableAPI.entity.Stop;
import com.project.timetable.TimetableAPI.exception.RouteNotFound;
import com.project.timetable.TimetableAPI.exception.StopNotFound;
import com.project.timetable.TimetableAPI.repository.RouteRepository;
import com.project.timetable.TimetableAPI.repository.StopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/route")
public class RouteController {

    @Autowired
    RouteRepository routeRepository;
    @Autowired
    StopRepository stopRepository;

    @PostMapping
    public ResponseEntity<Route> createRoute(@RequestBody RouteDto route) {
        Optional<Stop> depStop = stopRepository.findById(route.getDepartureStop());
        Optional<Stop> destStop = stopRepository.findById(route.getDestinationStop());
        if (depStop.isPresent() && destStop.isPresent()){
            Route newRoute = new Route(route.getName(), route.getInfo(), depStop.get(), destStop.get());
            routeRepository.save(newRoute);
            return new ResponseEntity<>(newRoute, HttpStatus.CREATED);
        } else {
            throw new StopNotFound("Invalid Stop Id");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Route> updateRoute(@PathVariable("id") Long id, @RequestBody RouteDto route){
        Optional<Route> routeData = routeRepository.findById(id);
        if (routeData.isPresent()){
            Optional<Stop> depStop = stopRepository.findById(route.getDepartureStop());
            Optional<Stop> destStop = stopRepository.findById(route.getDestinationStop());
            if (depStop.isPresent() && destStop.isPresent()){
                Route updatedRoute = routeData.get();
                updatedRoute.setName(route.getName());
                updatedRoute.setInfo(route.getInfo());
                updatedRoute.setDepartureStop(depStop.get());
                updatedRoute.setDestinationStop(destStop.get());
                routeRepository.save(updatedRoute);
                return new ResponseEntity<>(updatedRoute, HttpStatus.OK);
            } else {
                throw new StopNotFound("Invalid Stop ID");
            }
        } else {
            throw new RouteNotFound("Invalid Route ID");
        }
    }

    @GetMapping
    public ResponseEntity<List<Route>> getAllRoutes() {
        List<Route> routes = new ArrayList<>();
        routeRepository.findAll().forEach(routes::add);
        return new ResponseEntity<>(routes, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Route> getRouteById(@PathVariable("id") Long id) {
        Optional<Route> routeData = routeRepository.findById(id);
        if (routeData.isPresent()) {
            return new ResponseEntity<>(routeData.get(), HttpStatus.OK);
        } else {
            throw new RouteNotFound("Invalid Route Id");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Route> deleteRoute(@PathVariable("id") Long id) {

        Optional<Route> routeData = routeRepository.findById(id);
        if (routeData.isPresent()) {
            routeRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            throw new RouteNotFound("Invalid Route Id");
        }
    }
}
