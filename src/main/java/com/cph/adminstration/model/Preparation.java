package com.cph.adminstration.model;

import java.time.LocalDateTime;

public class Preparation {
    private int id;
    private int departureID;
    private LocalDateTime start;
    private LocalDateTime finish;
    private int planeProcessingId;
    private int arrival_id;

    public Preparation() {

    }

    public Preparation(int id, int departureID, LocalDateTime finish, int planeProcessingId, int arrival_id) {
        this.id = id;
        this.departureID = departureID;
        this.finish = finish;
        this.planeProcessingId = planeProcessingId;
        this.arrival_id = arrival_id;
    }

    public int getArrival_id() {
        return arrival_id;
    }

    public void setArrival_id(int arrival_id) {
        this.arrival_id = arrival_id;
    }

    public int getPlaneProcessingId() { return planeProcessingId; }

    public void setPlaneProcessingId(int planeProcessingId) { this.planeProcessingId = planeProcessingId; }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDepartureID() {
        return departureID;
    }

    public void setDepartureID(int departureID) {
        this.departureID = departureID;
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
                ", departureID=" + departureID +
                ", start=" + start +
                ", finish=" + finish +
                ", planeProcessingId=" + planeProcessingId +
                '}';
    }
}
