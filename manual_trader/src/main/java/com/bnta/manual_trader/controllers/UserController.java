package com.bnta.manual_trader.controllers;

import java.util.List;

import com.bnta.manual_trader.models.Car;
import com.bnta.manual_trader.models.User;
import com.bnta.manual_trader.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping ("users")
public class UserController {

    @Autowired
    UserRepository userRepository;

    //Index
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        return new ResponseEntity(userRepository.findAll(), HttpStatus.OK);
    }

    //Show
    @GetMapping(value ="/{id}")
    public ResponseEntity<List<User>> getUserByID(@PathVariable Long id){
        return new ResponseEntity(userRepository.findById(id), HttpStatus.OK);
    }

    //Post
    @PostMapping(value = "/new")
    public ResponseEntity<User> createUser(@RequestBody User user){
        return new ResponseEntity<>(userRepository.save(user), HttpStatus.CREATED);
    }

    //Delete
    @DeleteMapping(value = "/remove/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id){
        userRepository.deleteById(id);
        return new ResponseEntity<>("Deleted", HttpStatus.NOT_FOUND);

    }

}


