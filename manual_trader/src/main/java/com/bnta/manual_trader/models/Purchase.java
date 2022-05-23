package com.bnta.manual_trader.models;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "purchases")
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "customers_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "cars_id")
    private Car carPurchased;

    public Purchase(LocalDate date, Customer customer, Car carPurchased) {
        this.date = date;
        this.customer = customer;
        this.carPurchased = carPurchased;
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

    public Car getCarPurchased() {
        return carPurchased;
    }

    public void setCarPurchased(Car carPurchased) {
        this.carPurchased = carPurchased;
    }

    @Override
    public String toString() {
        return "Purchase{" +
                "id=" + id +
                ", date=" + date +
                ", customer=" + customer +
                ", carPurchased=" + carPurchased +
                '}';
    }
}
