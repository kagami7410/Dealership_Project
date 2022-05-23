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
    private int carYear;

    @Column
    private double price;

    @ManyToOne
    @JoinColumn(name = "dealerships_id")
    @JsonIgnoreProperties("cars")
    private Dealership dealership;

    public Car(String bodyType, String brand, String colour, int carYear, double price, Dealership dealership) {
        this.bodyType = bodyType;
        this.brand = brand;
        this.colour = colour;
        this.carYear = carYear;
        this.price = price;
        this.dealership = dealership;
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

    public int getCarYear() {
        return carYear;
    }

    public void setCarYear(int carYear) {
        this.carYear = carYear;
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

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", bodyType='" + bodyType + '\'' +
                ", brand='" + brand + '\'' +
                ", colour='" + colour + '\'' +
                ", carYear=" + carYear +
                ", price=" + price +
                ", dealership=" + dealership +
                '}';
    }
}
