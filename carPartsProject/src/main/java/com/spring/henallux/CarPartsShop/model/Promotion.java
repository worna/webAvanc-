package com.spring.henallux.CarPartsShop.model;

import java.util.Date;

public class Promotion {
    private int id;
    private String name;
    private int percent;
    private Date startDate;
    private Date endDate;

    public Promotion(int id, String name, int percent, Date startDate, Date endDate) {
        this.id = id;
        this.name = name;
        this.percent = percent;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Promotion() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPercent() {
        return percent;
    }

    public void setPercent(int percent) {
        this.percent = percent;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
