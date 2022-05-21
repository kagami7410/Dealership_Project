package com.bnta.manual_trader.models;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

public class Purchase {
    private Long id;
    private LocalDate date;
    @ManyToOne
    private Customer customer;
    @ManyToMany
    @JoinTable(name = "car_Purchases",
            joinColumns = {@JoinColumn(name = "purchase_id")},
            inverseJoinColumns = {@JoinColumn(name = "car_id")}
    )
    private List<Car> cars;


    public Purchase(LocalDate date, Customer customer, List<Car> cars) {
        this.date = date;
        this.customer = customer;
        this.cars = cars;
    }

    public Purchase() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }
}
