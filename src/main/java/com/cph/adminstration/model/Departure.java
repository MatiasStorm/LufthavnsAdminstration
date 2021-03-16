package com.cph.adminstration.model;

import java.time.LocalDateTime;

public class Departure {
    private int id;
    private LocalDateTime dateTime;
    private String routeNumber;
    private String AC;
    private String destination;
    private Boolean isDeparted;
    private int airplaneID;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getRouteNumber() {
        return routeNumber;
    }

    public void setRouteNumber(String routeNumber) {
        this.routeNumber = routeNumber;
    }

    public String getAC() {
        return AC;
    }

    public void setAC(String AC) {
        this.AC = AC;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Boolean getDeparted() {
        return isDeparted;
    }

    public void setDeparted(Boolean departed) {
        isDeparted = departed;
    }

    public int getAirplaneID() {
        return airplaneID;
    }

    public void setAirplaneID(int airplaneID) {
        this.airplaneID = airplaneID;
    }
}
