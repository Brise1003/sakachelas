package com.sakachelas.domain;

import java.math.BigDecimal;
import java.sql.Timestamp;


public class Order {
    private int orderId;
    private String trackingGuide;
    private String status;
    private Timestamp date;
    private int userId;
    private String payment;
    private BigDecimal total;

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getTrackingGuide() {
        return trackingGuide;
    }

    public void setTrackingGuide(String trackingGuide) {
        this.trackingGuide = trackingGuide;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

}
