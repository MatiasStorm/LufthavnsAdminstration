package com.cph.adminstration.model;

public class Plane {

    private int iata;
    private String type;
    private char planeSize;

    public int getIata() {
        return iata;
    }

    public void setIata(int iata) {
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
