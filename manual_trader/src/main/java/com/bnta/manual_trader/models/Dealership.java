package com.bnta.manual_trader.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "dealerships")
public class Dealership {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String location;

    @OneToMany(mappedBy = "dealership")
    @JsonIgnoreProperties("dealership")
    private List<Car> cars;

    @OneToMany(mappedBy = "dealership")
    @JsonIgnoreProperties("dealership")
    private List<Dealer> dealers;

    // Removed Cars and Dealers input in constructor
    public Dealership(String name, String location) {
        this.name = name;
        this.location = location;
        this.cars = new ArrayList<>();
        this.dealers = new ArrayList<>();
    }

    public Dealership() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Dealer> getDealers() {
        return dealers;
    }

    public void setDealers(List<Dealer> dealers) {
        this.dealers = dealers;
    }

    @Override
    public String toString() {
        return "Dealership{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", cars=" + cars +
                ", dealers=" + dealers +
                '}';
    }
}
