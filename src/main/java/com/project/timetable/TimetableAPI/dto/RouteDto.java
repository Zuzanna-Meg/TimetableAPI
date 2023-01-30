package com.project.timetable.TimetableAPI.entity;

import jakarta.persistence.*;

public class RouteDto {

    private Long id;
    private String name;
    private String info;
    private Long departureStop;
    private Long destinationStop;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Long getDepartureStop() {
        return departureStop;
    }

    public void setDepartureStop(Long departureStop) {
        this.departureStop = departureStop;
    }

    public Long getDestinationStop() {
        return destinationStop;
    }

    public void setDestinationStop(Long arrivalStop) {
        this.destinationStop = arrivalStop;
    }

    public RouteDto() {
        super();
    }

    public RouteDto(String name, String info, Long departureStop, Long destinationStop) {
        super();
        this.name = name;
        this.info = info;
        this.departureStop = departureStop;
        this.destinationStop = destinationStop;
    }

    public RouteDto(Long id, String name, String info, Long departureStop, Long destinationStop) {
        super();
        this.id = id;
        this.name = name;
        this.info = info;
        this.departureStop = departureStop;
        this.destinationStop = destinationStop;
    }
}
