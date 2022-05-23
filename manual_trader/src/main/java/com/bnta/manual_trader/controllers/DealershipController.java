package com.bnta.manual_trader.controllers;


import java.util.List;
import com.bnta.manual_trader.models.Dealership;
import com.bnta.manual_trader.repositories.DealershipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("dealerships")
public class DealershipController {

    @Autowired
    DealershipRepository dealershipRepository;

    @GetMapping
    public ResponseEntity<List<Dealership>> getAllDealership(){
        return new ResponseEntity<>(dealershipRepository.findall(), HttpStatus.OK);
    }



}
