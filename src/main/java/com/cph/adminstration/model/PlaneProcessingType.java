package com.cph.adminstration.model;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class PlaneProcessingType {

    private int workId;
    private String workType;
    private int departmentId;
    private LocalTime timeSmall;
    private LocalTime timeStandard;
    private LocalTime timeLarge;
    private List<Integer> dependencyIds;

    public PlaneProcessingType() {
    }

    public PlaneProcessingType(int workId, String workType, int departmentId, LocalTime timeSmall, LocalTime timeStandard, LocalTime timeLarge) {
        this.workId = workId;
        this.workType = workType;
        this.departmentId = departmentId;
        this.timeSmall = timeSmall;
        this.timeStandard = timeStandard;
        this.timeLarge = timeLarge;
    }

    public List<Integer> getDependencyIds() {
        return dependencyIds;
    }

    public void setDependencyIds(List<Integer> dependencyIds) {
        this.dependencyIds = dependencyIds;
    }

    public int getWorkId() {
        return workId;
    }

    public void setWorkId(int workId) {
        this.workId = workId;
    }

    public String getWorkType() {
        return workType;
    }

    public void setWorkType(String workType) {
        this.workType = workType;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public LocalTime getTimeSmall() {
        return timeSmall;
    }

    public void setTimeSmall(LocalTime timeSmall) {
        this.timeSmall = timeSmall;
    }

    public LocalTime getTimeStandard() {
        return timeStandard;
    }

    public void setTimeStandard(LocalTime timeStandard) {
        this.timeStandard = timeStandard;
    }

    public LocalTime getTimeLarge() {
        return timeLarge;
    }

    public void setTimeLarge(LocalTime timeLarge) {
        this.timeLarge = timeLarge;
    }


}
