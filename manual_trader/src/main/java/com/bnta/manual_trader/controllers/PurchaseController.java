package com.bnta.manual_trader.controllers;

import com.bnta.manual_trader.repositories.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("Purchases")
public class PurchaseController {

    @Autowired
    PurchaseRepository purchaseRepository;

// GET
    public ResponseEntity<List<Car>> getAllPurchasedCars () {
        return new ResponseEntity(purchaseRepository.findAll(), HttpStatus.OK);
    }





}
