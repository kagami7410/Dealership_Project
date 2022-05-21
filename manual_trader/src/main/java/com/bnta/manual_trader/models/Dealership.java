package com.bnta.manual_trader.models;

import javax.persistence.OneToMany;
import java.util.List;

public class Dealership {

    private Long id;
    private String name;
    private String location;

    @OneToMany(mappedBy = "cars")
    private List<Car> cars;

    public Dealership(String name, String location, List<Car> cars) {
        this.name = name;
        this.location = location;
        this.cars = cars;
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
}
