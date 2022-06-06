package com.bnta.manual_trader.controllers;

import java.time.LocalDate;
import java.util.List;

import com.bnta.manual_trader.models.Dealer;
import com.bnta.manual_trader.models.Purchase;
import com.bnta.manual_trader.repositories.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;

@RestController
@RequestMapping("purchases")
public class PurchaseController {

    @Autowired
    PurchaseRepository purchaseRepository;

    // GET
    @GetMapping
    public ResponseEntity<List<Purchase>> getAllPurchasedCarsByDate(
            @RequestParam(required = false, name = "date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        if (date != null) {
            return new ResponseEntity<>(purchaseRepository.findByDate(date), HttpStatus.OK);
        }
        return new ResponseEntity<>(purchaseRepository.findAll(), HttpStatus.OK);
    }

    // SHOW
    @GetMapping(value = "/{id}")
    public ResponseEntity<Purchase> getPurchasedCarById(@PathVariable Long id) {
        return new ResponseEntity(purchaseRepository.findById(id), HttpStatus.OK);
    }

    // POST
    @Transactional
    @PostMapping(value = "/new")
    public ResponseEntity<Purchase> createPurchase(@RequestBody Purchase purchase) {
        return new ResponseEntity<>(purchaseRepository.save(purchase), HttpStatus.CREATED);
    }

    // PUT
    @PutMapping(value = "update/{id}")
    public ResponseEntity<Purchase> updatePurchase(@PathVariable Long id, @RequestBody Purchase newPurchase) {
        var foundPurchase = purchaseRepository.findById(id);
        if (foundPurchase.isPresent()) {
            Purchase foundPurchaseGet = foundPurchase.get();
            foundPurchaseGet.setCarPurchased(newPurchase.getCarPurchased());
            foundPurchaseGet.setCustomer(newPurchase.getCustomer());
            foundPurchaseGet.setDate(newPurchase.getDate());
            purchaseRepository.save(foundPurchaseGet);
            return new ResponseEntity<>(foundPurchaseGet, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    // DELETE
    @DeleteMapping(value = "remove/{id}")
    public ResponseEntity<String> deletePurchase(@PathVariable Long id) {
        purchaseRepository.deleteById(id);
        return new ResponseEntity<>("Deleted Purchase ID: " + id, HttpStatus.NOT_FOUND);
    }


}

