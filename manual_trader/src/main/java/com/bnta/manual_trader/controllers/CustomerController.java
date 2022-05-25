package com.bnta.manual_trader.controllers;

import com.bnta.manual_trader.models.Customer;
import com.bnta.manual_trader.models.Dealer;
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

    //GET
    @GetMapping
    public ResponseEntity<List<Customer>> getCustomerAndByName(@RequestParam(required = false, name = "name") String name) {
        if (name != null) {
            return new ResponseEntity<>(customerRepository.getCustomerByName(name), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(customerRepository.findAll(), HttpStatus.OK);
        }
    }

    //SHOW
    @GetMapping(value = "/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Long id) {
        return new ResponseEntity(customerRepository.findById(id), HttpStatus.OK);
    }

    //POST
    @PostMapping(value = "/new")
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        return new ResponseEntity<>(customerRepository.save(customer), HttpStatus.CREATED);
    }

    //PUT
    @PutMapping(value = "/update/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable(value = "id") Long id, @RequestBody Customer newCustomer) {
        var foundCustomer = customerRepository.findById(id);
        if (foundCustomer.isPresent()) {
            Customer foundCustomerGet = foundCustomer.get();
            foundCustomerGet.setName(newCustomer.getName());
            foundCustomerGet.setEmailAddress(newCustomer.getEmailAddress());
            foundCustomerGet.setPurchases(newCustomer.getPurchases());
            customerRepository.save(foundCustomerGet);
            return new ResponseEntity(foundCustomerGet, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //DELETE
    @DeleteMapping(value = "remove/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable Long id) {
        String customerName = customerRepository.findById(id).get().getName();
        customerRepository.deleteById(id);
        return new ResponseEntity<>("Deleted Customer " + id + " " + customerName, HttpStatus.NOT_FOUND);
    }

}
