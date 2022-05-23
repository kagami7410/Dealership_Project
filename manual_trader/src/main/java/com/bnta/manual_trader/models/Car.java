package com.bnta.manual_trader.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String bodyType;

    @Column
    private String brand;

    @Column
    private String colour;

    @Column
    private int year;

    @Column
    private double price;

    @ManyToOne
    @JoinColumn(name = "dealerships_id", nullable = false)
    @JsonIgnoreProperties("dealership")
    private Dealership dealership;

    @ManyToMany(mappedBy = "")
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
