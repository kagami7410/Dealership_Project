package com.bnta.manual_trader.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "customers")
public class Customer{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String address;

    @OneToMany(mappedBy = "customer")
    private List<Purchase> purchases;

    public Customer(String address, List<Purchase> purchases) {
        this.address = address;
        this.purchases = purchases;
    }

    public Customer() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Purchase> getPurchases() {
        return purchases;
    }

    public void setPurchases(List<Purchase> purchases) {
        this.purchases = purchases;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", purchases=" + purchases +
                '}';
    }
}
