package com.spring.henallux.CarPartsShop.model;

import java.util.Date;

public class Order {
    private int id;
    private Date date;
    private Date paymentDate;
    private Date receptionDate;
    private User user;
    private Promotion promotion;

    public Order(int id, Date date, Date paymentDate, Date receptionDate, User user, Promotion promotion) {
        this.id = id;
        this.date = date;
        this.paymentDate = paymentDate;
        this.receptionDate = receptionDate;
        this.user = user;
        this.promotion = promotion;
    }

    public Order() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public Date getReceptionDate() {
        return receptionDate;
    }

    public void setReceptionDate(Date receptionDate) {
        this.receptionDate = receptionDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Promotion getPromotion() {
        return promotion;
    }

    public void setPromotion(Promotion promotion) {
        this.promotion = promotion;
    }
}
