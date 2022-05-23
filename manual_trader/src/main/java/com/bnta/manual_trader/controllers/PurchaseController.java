package com.bnta.manual_trader.controllers;

import java.util.List;
import com.bnta.manual_trader.models.Purchase;
import com.bnta.manual_trader.repositories.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("purchases")
public class PurchaseController {

    @Autowired
    PurchaseRepository purchaseRepository;

    // GET
    @GetMapping
    public ResponseEntity<List<Purchase>> getAllPurchasedCars() {
        return new ResponseEntity(purchaseRepository.findAll(), HttpStatus.OK);
    }
    
    // SHOW
    @GetMapping(value = "/{id}")
    public ResponseEntity<Purchase> getPurchasedCarById(@PathVariable Long id){
        return new ResponseEntity(purchaseRepository.findById(id), HttpStatus.OK);
    }

    // POST
    @PostMapping(value = "/new")
    public ResponseEntity<Purchase> createPurchase(@RequestBody Purchase purchase) {
        return new ResponseEntity<>(purchaseRepository.save(purchase), HttpStatus.OK);
    }

    // DELETE
    @DeleteMapping(value = "remove/{id}")
    public ResponseEntity<String> deletePurchase(@PathVariable Long id) {
        purchaseRepository.deleteById(id);
        return new ResponseEntity<>("Deleted", HttpStatus.NOT_FOUND);
    }

}
