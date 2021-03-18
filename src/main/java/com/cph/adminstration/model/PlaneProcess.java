package com.cph.adminstration.model;

import java.time.LocalDateTime;

public class PlaneProcess {
    private int work_id;
    private int departureId;
    private LocalDateTime start;
    private LocalDateTime end;
    private int planeProcessingId;
    private int arrivalId;

    public PlaneProcess() {

    }

    public PlaneProcess(int work_id, int departureId, LocalDateTime end, int planeProcessingId, int arrivalId) {
        this.work_id = work_id;
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

    public int getWork_id() {
        return work_id;
    }

    public void setWork_id(int work_id) {
        this.work_id = work_id;
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
                "id=" + work_id +
                ", departureID=" + departureId +
                ", start=" + start +
                ", finish=" + end +
                ", planeProcessingId=" + planeProcessingId +
                '}';
    }
}
