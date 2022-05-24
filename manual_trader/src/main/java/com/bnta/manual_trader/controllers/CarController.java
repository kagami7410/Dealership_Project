package com.bnta.manual_trader.controllers;


import com.bnta.manual_trader.models.Bodytype;
import com.bnta.manual_trader.models.Car;
import com.bnta.manual_trader.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.function.Function;

@RestController
@RequestMapping("cars")
public class CarController {

    @Autowired
    CarRepository carRepository;

    // Get car by attributes
    @GetMapping
    public ResponseEntity<List<Car>> getCarByAttribute(@RequestParam(required = false, name = "brand") String brand,
                                                       @RequestParam(required = false, name = "colour") String colour,
                                                       @RequestParam(required = false, name = "bodyType") Bodytype bodyType,
                                                       @RequestParam(required = false, name = "year") Integer year,
                                                       @RequestParam(required = false, name = "price") Double price) {

        List listOfRequest = List.of(brand, colour, bodyType, year, price);
        List<Integer> listOfCorrespondingNumber = List.of(1, 2, 3, 4, 5);
        int requestScore;
        int counter = 0;

        for (int i = 0; i < listOfRequest.size(); i++) {
            if (listOfRequest.get(i) != null) {
                requestScore = listOfCorrespondingNumber.get(i);
                requestScore += requestScore;
                counter += 1;
            }
        }

        switch (requestScore) {
            case 1:
                return new ResponseEntity<>(carRepository.findByBrand(brand), HttpStatus.OK);
            break;
            case 2:
                return new ResponseEntity<>(carRepository.findByColour(colour), HttpStatus.OK);
            break;
            case 3:
                if (counter != 2) {
                    return new ResponseEntity<>(carRepository.findByBodyType(bodyType), HttpStatus.OK);
                } else {
                    return new ResponseEntity<>(carRepository.findByBrandAndColour(brand, colour), HttpStatus.OK);
                }
            case 4:
                if (counter != 2) {
                    return new ResponseEntity<>(carRepository.findByCarYearGreaterThan(year), HttpStatus.OK);
                } else {
                    return new ResponseEntity<>(carRepository.findByBrandAndBodyType(brand, bodyType), HttpStatus.OK);
                }
            case 5:
                if (counter == 2) {
                    return new ResponseEntity<>(carRepository.findByPriceGreaterThan(price),HttpStatus.OK);
                }else if(counter == 1){
                    return new ResponseEntity<>(carRepository.findByBrandAndCarYearGreaterThan(brand, year), HttpStatus.OK);
                }else {
                    return new ResponseEntity<>(carRepository.findByBrandAndColourAndBodyType(brand,colour,bodyType), HttpStatus.OK);
                }
            case 6:
                if(counter == 2) {
                    if(listOfRequest.get(2).equals(null)){
                        return new ResponseEntity<>(carRepository.findByBrandAndPriceGreaterThan(brand, price), HttpStatus.OK);
                    }
                    else {
                        return new ResponseEntity<>(carRepository.findByColour())
                    }

                }


        }
    }



    // GET byBrand
    @GetMapping
    public ResponseEntity<List<Car>> getAllCarsAndByBrand(@RequestParam(required = false, name = "brand") String brand) {
        if (brand != null) {
            return new ResponseEntity(carRepository.findByBrand(brand), HttpStatus.OK);
        }
        return new ResponseEntity(carRepository.findAll(), HttpStatus.OK);
    }

    // GET byBodyType
    @GetMapping
    public ResponseEntity<List<Car>> getAllCarsAndByBodyType(@RequestParam(required = false, name = "bodyType") Bodytype bodyType) {
        if (bodyType != null) {
            return new ResponseEntity(carRepository.findByBodyType(bodyType), HttpStatus.OK);
        }
        return new ResponseEntity(carRepository.findAll(), HttpStatus.OK);
    }

    // GET byColour
    @GetMapping
    public ResponseEntity<List<Car>> getAllCarsAndByColour(@RequestParam(required = false, name = "colour") String colour) {
        if (colour != null) {
            return new ResponseEntity(carRepository.findByColour(colour), HttpStatus.OK);
        }
        return new ResponseEntity(carRepository.findAll(), HttpStatus.OK);
    }
    // GET byYear
    @GetMapping
    public ResponseEntity<List<Car>> getAllCarsAndByYear(@RequestParam(required = false, name = "carYear") Integer carYear) {
        if (carYear != null) {
            return new ResponseEntity(carRepository.findByYear(carYear), HttpStatus.OK);
        }
        return new ResponseEntity(carRepository.findAll(), HttpStatus.OK);
    }

    // GET byPrice
    @GetMapping
    public ResponseEntity<List<Car>> findByPriceGreaterThan(@RequestParam(required = false, name = "price") Double price) {
        if (price != null) {
            return new ResponseEntity(carRepository.findByPriceGreaterThan(price), HttpStatus.OK);
        }
        return new ResponseEntity(carRepository.findAll(), HttpStatus.OK);
    }


    // SHOW
    @GetMapping(value = "/{id}")
    public ResponseEntity<List<Car>> getCarById(@PathVariable Long id) {
        return new ResponseEntity(carRepository.findById(id), HttpStatus.OK);
    }


    // SHOW


    // POST
    @PostMapping(value = "/new")
    public ResponseEntity<Car> createCar(@RequestBody Car car) {
        return new ResponseEntity<>(carRepository.save(car), HttpStatus.CREATED);
    }


    // PUT
    @PutMapping(value = "/update/{id}")
    public ResponseEntity<Car> updateCar(@PathVariable Long id, @RequestBody Car newCar) {
        var foundCar = carRepository.findById(id);
        if (foundCar.isPresent()) {
            Car foundCarGet = foundCar.get();
            foundCarGet.setColour(newCar.getColour());
            foundCarGet.setPrice(newCar.getPrice());
            foundCarGet.setDealership(newCar.getDealership());
            carRepository.save(foundCarGet);
            return new ResponseEntity(foundCarGet, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // DELETE
    @DeleteMapping(value = "remove/{id}")
    public ResponseEntity<String> deleteCar(@PathVariable Long id) {
        carRepository.deleteById(id);
        return new ResponseEntity<>("Deleted", HttpStatus.NOT_FOUND);

    }
}
