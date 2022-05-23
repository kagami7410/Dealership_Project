package com.bnta.manual_trader.models;

import javax.persistence.*;

@Entity
@Table(name = "dealers")
public class Dealer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private int permissionLvl;

    @ManyToOne
    @JoinColumn(name = "dealerships_ids")
    private Dealership dealership;

    public Dealer(int permissionLvl, Dealership dealership) {
        this.permissionLvl = permissionLvl;
        this.dealership = dealership;
    }

    public Dealer() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getPermissionLvl() {
        return permissionLvl;
    }

    public void setPermissionLvl(int permissionLvl) {
        this.permissionLvl = permissionLvl;
    }

    public Dealership getDealership() {
        return dealership;
    }

    public void setDealership(Dealership dealership) {
        this.dealership = dealership;
    }

    @Override
    public String toString() {
        return "Dealer{" +
                "id=" + id +
                ", permissionLvl=" + permissionLvl +
                ", dealership=" + dealership +
                '}';
    }
}
