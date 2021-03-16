package com.cph.adminstration.model;

import java.time.LocalDateTime;

public class Preparation {
    private String name;
    private int id;
    private String department;
    private LocalDateTime start;
    private LocalDateTime finish;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
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

    public Preparation(String name, int id, String department, LocalDateTime start, LocalDateTime finish) {
        this.name = name;
        this.id = id;
        this.department = department;
        this.start =  start;
        this.finish = finish;
    }

    @Override
    public String toString() {
        return "Preparation{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", department='" + department + '\'' +
                ", start=" + start +
                ", finish=" + finish +
                '}';
    }
}
