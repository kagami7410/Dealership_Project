package com.bnta.manual_trader.models;

import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import java.util.List;

public class Customer{
    private Long id;
    private String address;
    @OneToMany(mappedBy = "purchases")
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
}
