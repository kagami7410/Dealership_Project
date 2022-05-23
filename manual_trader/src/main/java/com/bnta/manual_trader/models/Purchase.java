package com.bnta.manual_trader.models;

import org.hibernate.sql.Insert;

import javax.persistence.*;
import java.awt.*;
import java.time.LocalDate;
import java.util.List;

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

    @ManyToMany(mappedBy = "")
    @JoinTable(name = "cars_purchases",
            joinColumns = {@JoinColumn(name = "purchases_id", nullable = false)},
            inverseJoinColumns = {@JoinColumn(name = "cars_id", nullable = false)})

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

    @Override
    public String toString() {
        return "Purchase{" +
                "id=" + id +
                ", date=" + date +
                ", customer=" + customer +
                ", cars=" + cars +
                '}';
    }
}
