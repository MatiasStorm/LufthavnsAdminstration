package com.cph.adminstration.model;

public class Plane {

    private String iata;
    private String type;
    private char planeSize;

    public String getIata() {
        return iata;
    }

    public void setIata(String iata) {
        this.iata = iata;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public char getPlaneSize() {
        return planeSize;
    }

    public void setPlaneSize(char planeSize) {
        this.planeSize = planeSize;
    }
}
