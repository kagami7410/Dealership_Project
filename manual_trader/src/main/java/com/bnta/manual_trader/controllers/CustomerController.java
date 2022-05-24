package com.bnta.manual_trader.controllers;

import com.bnta.manual_trader.models.Customer;
import com.bnta.manual_trader.models.Purchase;
import com.bnta.manual_trader.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("customers")
public class CustomerController {
    @Autowired
    CustomerRepository customerRepository;

    @GetMapping
    public ResponseEntity<List<Customer>> getCustomerByName(@RequestParam(required = false, name = "name") String name) {
        if (name != null) {
            return new ResponseEntity<>(customerRepository.getCustomerByName(name), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(customerRepository.findAll(), HttpStatus.OK);
        }
    }

//    // GET
//    @GetMapping
//    public ResponseEntity<List<Customer>> getAllCustomers() {
//        return new ResponseEntity(customerRepository.findAll(), HttpStatus.OK);
//    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Long id) {
        return new ResponseEntity(customerRepository.findById(id), HttpStatus.OK);
    }

    //POST
    @PostMapping(value = "/new")
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        return new ResponseEntity<>(customerRepository.save(customer), HttpStatus.OK);
    }

    //DELETE
    @DeleteMapping(value = "remove/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable Long id) {
        customerRepository.deleteById(id);
        return new ResponseEntity<>("Deleted Customer" + id, HttpStatus.NOT_FOUND);
    }

}
