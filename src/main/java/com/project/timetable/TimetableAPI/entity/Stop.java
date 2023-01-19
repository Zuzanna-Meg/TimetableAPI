package com.project.timetable.TimetableAPI.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "stop")
public class Stop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "town")
    private String town;

    @Column(name = "station")
    private boolean station;

    public Stop() {
        super();
    }

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

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public boolean isStation() {
        return station;
    }

    public void setStation(boolean station) {
        this.station = station;
    }

    public Stop(String name, String town, boolean station) {
        super();
        this.name = name;
        this.town = town;
        this.station = station;
    }

    public Stop(Long id, String name, String town, boolean station) {
        super();
        this.id = id;
        this.name = name;
        this.town = town;
        this.station = station;
    }
}
