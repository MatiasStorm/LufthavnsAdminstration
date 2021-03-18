package com.cph.adminstration.model;

import java.time.LocalDateTime;

public class PlaneProcess {
    private int id;
    private int departureId;
    private LocalDateTime start;
    private LocalDateTime finish;
    private int planeProcessingId;
    private int arrivalId;

    public PlaneProcess() {

    }

    public PlaneProcess(int id, int departureId, LocalDateTime finish, int planeProcessingId, int arrivalId) {
        this.id = id;
        this.departureId = departureId;
        this.finish = finish;
        this.planeProcessingId = planeProcessingId;
        this.arrivalId = arrivalId;
    }

    public int getArrivalId() {
        return arrivalId;
    }

    public void setArrivalId(int arrivalId) {
        this.arrivalId = arrivalId;
    }

    public int getPlaneProcessingId() { return planeProcessingId; }

    public void setPlaneProcessingId(int planeProcessingId) { this.planeProcessingId = planeProcessingId; }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDepartureId() {
        return departureId;
    }

    public void setDepartureId(int departureId) {
        this.departureId = departureId;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public LocalDateTime getFinish() {
        return finish;
    }

    public void setFinish(LocalDateTime finish) {
        this.finish = finish;
    }

    @Override
    public String toString() {
        return "Preparation{" +
                "id=" + id +
                ", departureID=" + departureId +
                ", start=" + start +
                ", finish=" + finish +
                ", planeProcessingId=" + planeProcessingId +
                '}';
    }
}
