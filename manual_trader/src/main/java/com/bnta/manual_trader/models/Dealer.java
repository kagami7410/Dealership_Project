package com.bnta.manual_trader.models;

import javax.persistence.OneToOne;

public class Dealer {
    private Long id;
    private int permissionLvl;
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

}
