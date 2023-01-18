package com.project.timetable.TimetableAPI.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "bus")
public class Bus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "seats")
    private Long seats;
    @Column(name = "type")
    private String type;
    @Column(name = "access")
    private String access;

    public Bus() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSeats() {
        return seats;
    }

    public void setSeats(Long seats) {
        this.seats = seats;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAccess() {
        return access;
    }

    public void setAccess(String access) {
        this.access = access;
    }

    public Bus(Long seats, String type, String access) {
        super();
        this.seats = seats;
        this.type = type;
        this.access = access;
    }
}
