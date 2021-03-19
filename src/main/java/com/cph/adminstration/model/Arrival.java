package com.cph.adminstration.model;
import java.time.LocalDateTime;


public class Arrival  implements DailyPlanning{
    private int id;
    private LocalDateTime dateTime;
    private String routeNumber;
    private String ac;
    private String destination;
    private Boolean isArrived;

    public Arrival(){}

    public Arrival(int id, LocalDateTime dateTime, String routeNumber, String ac, String destination, boolean isArrived){
        this(dateTime, routeNumber, ac, destination, isArrived);
        this.id = id;
    }

    public Arrival(LocalDateTime dateTime, String routeNumber, String ac, String destination, boolean isArrived){
        this.dateTime = dateTime;
        this.routeNumber = routeNumber;
        this.ac = ac;
        this.destination = destination;
        this.isArrived = isArrived;
    }

    public String getTravelType(){
        return "Arrival";
    }



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

    public String getAc() {
        return ac;
    }

    public void setAc(String AC) {
        this.ac = AC;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Boolean getIsArrived() {
        return isArrived;
    }

    public void setIsArrived(Boolean arrived) {
        isArrived = arrived;
    }


}
