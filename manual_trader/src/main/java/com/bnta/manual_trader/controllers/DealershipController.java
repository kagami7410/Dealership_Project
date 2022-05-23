package com.bnta.manual_trader.controllers;


import java.util.List;
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
    public ResponseEntity<List<Dealership>> getAllDealership(){
        return new ResponseEntity<>(dealershipRepository.findall(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Dealership> getDealership(@PathVariable Long id){
        return new ResponseEntity<>(dealershipRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/new")
    public ResponseEntity<Dealership> createDealership(@RequestBody Dealership dealership){
        return new ResponseEntity<>(dealershipRepository.save(dealership), HttpStatus.CREATED);

    }

    @DeleteMapping(value = "remove/{id}")
    public ResponseEntity<String> deleteDealership(@PathVariable Long id){
        dealershipRepository.deleteById(id);
        return new ResponseEntity<>("Deleted", HttpStatus.NOT_FOUND);
    }





}
