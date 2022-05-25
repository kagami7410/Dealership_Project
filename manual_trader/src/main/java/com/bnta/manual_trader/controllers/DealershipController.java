package com.bnta.manual_trader.controllers;


import java.util.List;

import com.bnta.manual_trader.models.Dealer;
import com.bnta.manual_trader.models.Dealership;
import com.bnta.manual_trader.repositories.DealershipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("dealerships")
public class DealershipController {

    @Autowired
    DealershipRepository dealershipRepository;

    @GetMapping
    public ResponseEntity<List<Dealership>> getAllDealershipsByNameAndByLocation(@RequestParam(required = false, name = "name") String name,
                                                                                 @RequestParam(required = false, name = "location")
                                                                                         String location) {
        if (name != null && location != null) {
            return new ResponseEntity<>(dealershipRepository.findByNameContainingAndLocation(name, location), HttpStatus.OK);
        } else if (name != null && location == null) {
            return new ResponseEntity<>(dealershipRepository.findByNameContaining(name), HttpStatus.OK);
        } else if (name == null && location != null) {
            return new ResponseEntity<>(dealershipRepository.findByLocation(location), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(dealershipRepository.findAll(), HttpStatus.OK);
        }
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Dealership> getDealership(@PathVariable Long id) {
        return new ResponseEntity(dealershipRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/new")
    public ResponseEntity<Dealership> createDealership(@RequestBody Dealership dealership) {
        return new ResponseEntity<>(dealershipRepository.save(dealership), HttpStatus.CREATED);

    }

    @DeleteMapping(value = "remove/{id}")
    public ResponseEntity<String> deleteDealership(@PathVariable Long id) {
        dealershipRepository.deleteById(id);
        return new ResponseEntity<>("Deleted", HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "update/{id}")
    public ResponseEntity<Dealership> updateDealership(@PathVariable Long id, @RequestBody Dealership newDealership) {
        var foundDealership = dealershipRepository.findById(id);
        if (foundDealership.isPresent()) {
            Dealership foundDealershipGet = foundDealership.get();
            foundDealershipGet.setDealers(newDealership.getDealers());
            foundDealershipGet.setCars(newDealership.getCars());
            foundDealershipGet.setLocation(newDealership.getLocation());
            foundDealershipGet.setName(newDealership.getName());
            dealershipRepository.save(foundDealershipGet);
            return new ResponseEntity(foundDealershipGet, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}
