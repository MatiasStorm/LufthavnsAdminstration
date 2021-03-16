package com.cph.adminstration.model;

public class Preparation {
    private String name;
    private int id;
    private String department;
    private int start;
    private int finish;

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

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getFinish() {
        return finish;
    }

    public void setFinish(int finish) {
        this.finish = finish;
    }

    public Preparation(String name, int id, String department, int start, int finish) {
        this.name = name;
        this.id = id;
        this.department = department;
        this.start = start;
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
