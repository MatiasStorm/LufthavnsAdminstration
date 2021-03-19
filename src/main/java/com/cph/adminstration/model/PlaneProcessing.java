package com.cph.adminstration.model;

import java.time.LocalDateTime;

public class PlaneProcessing {
    private int workId;
    private int departureId;
    private LocalDateTime start;
    private LocalDateTime end;
    private int planeProcessingId;
    private int arrivalId;

    public PlaneProcessing() {

    }

    public PlaneProcessing(int workId, int departureId, LocalDateTime end, int planeProcessingId, int arrivalId) {
        this.workId = workId;
        this.departureId = departureId;
        this.end = end;
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

    public int getWorkId() {
        return workId;
    }

    public void setWorkId(int workId) {
        this.workId = workId;
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

    public LocalDateTime getEnd() {
        return end;
    }

    public void setEnd(LocalDateTime end) {
        this.end = end;
    }

    @Override
    public String toString() {
        return "Preparation{" +
                "id=" + workId +
                ", departureID=" + departureId +
                ", start=" + start +
                ", finish=" + end +
                ", planeProcessingId=" + planeProcessingId +
                '}';
    }
}
