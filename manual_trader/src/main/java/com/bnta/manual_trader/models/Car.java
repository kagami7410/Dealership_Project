package com.bnta.manual_trader.models;

import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.ArrayList;
import java.util.List;

public class Car {
    private Long id;
    private String bodyType;
    private String brand;
    private String colour;
    private int year;
    private double price;

    @ManyToOne
    private Dealership dealership;

    @ManyToMany(mappedBy = "cars")
    private List<Purchase> purchases;

    public Car(String bodyType, String brand, String colour, int year, double price, Dealership dealership) {
        this.bodyType = bodyType;
        this.brand = brand;
        this.colour = colour;
        this.year = year;
        this.price = price;
        this.dealership = dealership;
        this.purchases = new ArrayList<Purchase>();
    }

    public Car() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBodyType() {
        return bodyType;
    }

    public void setBodyType(String bodyType) {
        this.bodyType = bodyType;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Dealership getDealership() {
        return dealership;
    }

    public void setDealership(Dealership dealership) {
        this.dealership = dealership;
    }

    public List<Purchase> getPurchases() {
        return purchases;
    }

    public void setPurchases(List<Purchase> purchases) {
        this.purchases = purchases;
    }
}
