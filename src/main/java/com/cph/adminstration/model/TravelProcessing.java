package com.cph.adminstration.model;

public class TravelProcessing {
    private int id;
    private int departmentId;
    private int travelProcessId;
    private int fromDepartureId;
    private int fromArrivalId;
    private int toDepartureId;
    private int toArrivalId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public int getTravelProcessId() {
        return travelProcessId;
    }

    public void setTravelProcessId(int travelProcessId) {
        this.travelProcessId = travelProcessId;
    }

    public int getFromDepartureId() {
        return fromDepartureId;
    }

    public void setFromDepartureId(int fromDepartureId) {
        this.fromDepartureId = fromDepartureId;
    }

    public int getFromArrivalId() {
        return fromArrivalId;
    }

    public void setFromArrivalId(int fromArrivalId) {
        this.fromArrivalId = fromArrivalId;
    }

    public int getToDepartureId() {
        return toDepartureId;
    }

    public void setToDepartureId(int toDepartureId) {
        this.toDepartureId = toDepartureId;
    }

    public int getToArrivalId() {
        return toArrivalId;
    }

    public void setToArrivalId(int toArrivalId) {
        this.toArrivalId = toArrivalId;
    }
}
