package com.sakachelas.domain;

import com.sakachelas.persistance.entity.Producto;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;

import java.util.List;

public class Brewer {
    private Integer brewerId;
    private String brewerEmail;
    private String phone;
    private String brand;
    private String brewerName;
    private String brewerLastname;

    public Integer getBrewerId() {
        return brewerId;
    }

    public void setBrewerId(Integer brewerId) {
        this.brewerId = brewerId;
    }

    public String getBrewerEmail() {
        return brewerEmail;
    }

    public void setBrewerEmail(String brewerEmail) {
        this.brewerEmail = brewerEmail;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getBrewerName() {
        return brewerName;
    }

    public void setBrewerName(String brewerName) {
        this.brewerName = brewerName;
    }

    public String getBrewerLastname() {
        return brewerLastname;
    }

    public void setBrewerLastname(String brewerLastname) {
        this.brewerLastname = brewerLastname;
    }
}
