package com.bnta.manual_trader.controllers;

import java.util.List;
import com.bnta.manual_trader.models.User;
import com.bnta.manual_trader.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("users")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        return new ResponseEntity(userRepository.findAll(), HttpStatus.OK)
    }

    @GetMapping



}


