package com.bnta.manual_trader.controllers;


import com.bnta.manual_trader.models.Car;
import com.bnta.manual_trader.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cars")
public class CarController {

    @Autowired
    CarRepository carRepository;


    @GetMapping
    public ResponseEntity<List<Car>> getAllCarsAndByBrand(@RequestParam(required = false, name = "brand") String brand ){
        if (brand != null){
            return new ResponseEntity(carRepository.findByBrand(brand), HttpStatus.OK);
        }
        return new ResponseEntity(carRepository.findAll(), HttpStatus.OK);
    }

//    @GetMapping
//    public ResponseEntity<List<Car>> getAllCarsAndByColour(@RequestParam(required = false, name = "colour") String colour ){
//        if (colour != null){
//            return new ResponseEntity(carRepository.findByColour(colour), HttpStatus.OK);
//        }
//        return new ResponseEntity(carRepository.findAll(), HttpStatus.OK);
//    }

//    @GetMapping
//    public ResponseEntity<List<Car>> getAllCarsAndByYear(@RequestParam(required = false, name = "year") Integer year ){
//        if (year != null){
//            return new ResponseEntity(carRepository.findByYear(year), HttpStatus.OK);
//        }
//        return new ResponseEntity(carRepository.findAll(), HttpStatus.OK);
//    }

    
    // SHOW
    @GetMapping(value = "/{id}")
    public ResponseEntity<List<Car>> getCarById(@PathVariable Long id){
        return new ResponseEntity(carRepository.findById(id), HttpStatus.OK);
    }


    // POST
    @PostMapping(value = "/new")
    public ResponseEntity<Car> createCar(@RequestBody Car car){
        return new ResponseEntity<>(carRepository.save(car), HttpStatus.CREATED);
    }
    
    // DELETE
    @DeleteMapping(value = "remove/{id}")
    public ResponseEntity<String> deleteCar(@PathVariable Long id){
        carRepository.deleteById(id);
        return new ResponseEntity<>("Deleted", HttpStatus.NOT_FOUND);
        
    }
}
