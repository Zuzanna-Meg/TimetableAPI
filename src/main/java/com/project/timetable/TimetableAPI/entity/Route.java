//package com.project.timetable.TimetableAPI.entity;
//
//import jakarta.persistence.*;
//
//@Entity
//@Table(name = "route")
//public class Route {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @Column(name = "name")
//    private String name;
//
//    @Column(name = "info")
//    private String info;
//
//    @ManyToOne
//    @JoinColumn(name = "departure_stop")
//    private Stop departureStop;
//
//    @ManyToOne
//    @JoinColumn(name = "destination_stop")
//    private Stop destinationStop;
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getInfo() {
//        return info;
//    }
//
//    public void setInfo(String info) {
//        this.info = info;
//    }
//
//    public Stop getDepartureStop() {
//        return departureStop;
//    }
//
//    public void setDepartureStop(Stop departureStop) {
//        this.departureStop = departureStop;
//    }
//
//    public Stop getDestinationStop() {
//        return destinationStop;
//    }
//
//    public void setDestinationStop(Stop arrivalStop) {
//        this.destinationStop = arrivalStop;
//    }
//
//    public Route() {
//        super();
//    }
//
//    public Route(String name, String info, Stop departureStop, Stop destinationStop) {
//        super();
//        this.name = name;
//        this.info = info;
//        this.departureStop = departureStop;
//        this.destinationStop = destinationStop;
//    }
//
//    public Route(Long id, String name, String info, Stop departureStop, Stop destinationStop) {
//        super();
//        this.id = id;
//        this.name = name;
//        this.info = info;
//        this.departureStop = departureStop;
//        this.destinationStop = destinationStop;
//    }
//}
