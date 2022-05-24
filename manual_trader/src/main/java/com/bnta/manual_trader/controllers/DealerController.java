package com.bnta.manual_trader.controllers;

import java.util.List;

import com.bnta.manual_trader.models.Dealer;
import com.bnta.manual_trader.models.Dealership;
import com.bnta.manual_trader.repositories.DealerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("dealers")
public class DealerController {

    @Autowired
    DealerRepository dealerRepository;

    // GET
    @GetMapping
    public ResponseEntity<List<Dealer>> getAllDealers() {
        return new ResponseEntity(dealerRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Dealer>> getAllDealersByName(@RequestParam(required = false, name = "name") String name) {
        if(name != null) {
            return new ResponseEntity(dealerRepository.findDealersByName(name), HttpStatus.OK);
        }
        return new ResponseEntity(dealerRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Dealer>> getAllDealersByDealership(@RequestParam(required = false, name = "dealership") Dealership dealership) {
        if(dealership != null) {
            return new ResponseEntity<>(dealerRepository.findDealersByDealerships(dealership), HttpStatus.OK);
        }
        return new ResponseEntity<>(dealerRepository.findAll(), HttpStatus.OK);
    }


    // SHOW
    @GetMapping(value = "/{id}")
    public ResponseEntity<Dealer> getDealerById(@PathVariable Long id) {
        return new ResponseEntity(dealerRepository.findById(id), HttpStatus.OK);
    }

    // POST
    @PostMapping(value = "/new")
    public ResponseEntity<Dealer> createDealer(@RequestBody Dealer dealer) {
        return new ResponseEntity<>(dealerRepository.save(dealer), HttpStatus.CREATED);
    }

    // DELETED
    @DeleteMapping(value = "/remove/{id}")
    public ResponseEntity<String> deleteDealer(@PathVariable Long id) {
        dealerRepository.deleteById(id);
        return new ResponseEntity<>("Deleted Dealer " + id, HttpStatus.OK);
    }

    // PUT

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<Dealer> updateDealer(@PathVariable Long id, @RequestBody Dealer newDealer) {
        var foundDealer = dealerRepository.findById(id);
        if (foundDealer.isPresent()) {
            Dealer foundDealerGet = foundDealer.get();
            foundDealerGet.setDealership(newDealer.getDealership());
            dealerRepository.save(foundDealerGet);
            return new ResponseEntity(foundDealerGet, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

}


