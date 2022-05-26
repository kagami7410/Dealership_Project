package com.bnta.manual_trader.controllers;


import com.bnta.manual_trader.models.Bodytype;
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

    // Get car by attributes
    @GetMapping
    public ResponseEntity<List<Car>> getCarByAttribute(@RequestParam(required = false, name = "brand") String brand,
                                                       @RequestParam(required = false, name = "colour") String colour,
                                                       @RequestParam(required = false, name = "bodyType") Bodytype bodyType,
                                                       @RequestParam(required = false, name = "year") Integer year,
                                                       @RequestParam(required = false, name = "price") Double price) {
        List<Integer> listOfCorrespondingNumber = List.of(1, 2, 3, 4, 5);
        int previousScore = 0;
        int requestScore = 0;
        int counter = 0;

        if (brand != null) {
            previousScore = listOfCorrespondingNumber.get(0);
            requestScore += previousScore;
            counter += 1;
        }
        if (colour != null) {
            previousScore = listOfCorrespondingNumber.get(1);
            requestScore += previousScore;
            counter += 1;
        }
        if (bodyType != null) {
            previousScore = listOfCorrespondingNumber.get(2);
            requestScore += previousScore;
            counter += 1;
        }
        if (year != null) {
            previousScore = listOfCorrespondingNumber.get(3);
            requestScore += previousScore;
            counter += 1;
        }
        if (price != null) {
            previousScore = listOfCorrespondingNumber.get(4);
            requestScore += previousScore;
            counter += 1;
        }

        switch (requestScore) {
            case 1:
                return new ResponseEntity<>(carRepository.findByBrandIgnoreCase(brand), HttpStatus.OK);
            case 2:
                return new ResponseEntity<>(carRepository.findByColourIgnoreCase(colour), HttpStatus.OK);
            case 3:
                if (counter != 2) {
                    return new ResponseEntity<>(carRepository.findByBodyType(bodyType), HttpStatus.OK);
                } else {
                    return new ResponseEntity<>(carRepository.findByBrandIgnoreCaseAndColourIgnoreCase(brand, colour), HttpStatus.OK);
                }
            case 4:
                if (counter != 2) {
                    return new ResponseEntity<>(carRepository.findByCarYearGreaterThanEqual(year), HttpStatus.OK);
                } else {
                    return new ResponseEntity<>(carRepository.findByBrandIgnoreCaseAndBodyType(brand, bodyType), HttpStatus.OK);
                }
            case 5:
                if (counter == 2) {
                    if (brand == null) {
                        return new ResponseEntity<>(carRepository.findByColourIgnoreCaseAndBodyType(colour, bodyType), HttpStatus.OK);
                    } else {
                        return new ResponseEntity<>(carRepository.findByBrandIgnoreCaseAndCarYearGreaterThanEqual(brand, year), HttpStatus.OK);
                    }
                } else if (counter == 1) {
                    return new ResponseEntity<>(carRepository.findByPriceLessThanEqual(price), HttpStatus.OK);
                }
            case 6:
                if (counter == 2) {
                    if (bodyType == null) {
                        return new ResponseEntity<>(carRepository.findByBrandIgnoreCaseAndPriceLessThanEqual(brand, price), HttpStatus.OK);
                    } else {
                        return new ResponseEntity<>(carRepository.findByColourIgnoreCaseAndCarYearGreaterThanEqual(colour, year), HttpStatus.OK);
                    }
                } else if (counter == 3) {
                    return new ResponseEntity<>(carRepository.findByBrandIgnoreCaseAndColourIgnoreCaseAndBodyType(brand, colour, bodyType), HttpStatus.OK);
                }
            case 7:
                if (counter == 3) {
                    return new ResponseEntity<>(carRepository.findByBrandIgnoreCaseAndColourIgnoreCaseAndCarYearGreaterThanEqual(brand, colour, year), HttpStatus.OK);
                }
                if (counter == 2) {
                    if (bodyType == null) {
                        return new ResponseEntity<>(carRepository.findByColourIgnoreCaseAndPriceLessThanEqual(colour, price), HttpStatus.OK);
                    } else {
                        return new ResponseEntity<>(carRepository.findByBodyTypeAndCarYearGreaterThanEqual(bodyType, year), HttpStatus.OK);
                    }
                }
            case 8:
                if (counter == 3) {
                    if (colour == null) {
                        return new ResponseEntity<>(carRepository.findByBrandIgnoreCaseAndBodyTypeAndCarYearGreaterThanEqual(brand, bodyType, year), HttpStatus.OK);
                    } else {
                        return new ResponseEntity<>(carRepository.findByBrandIgnoreCaseAndColourIgnoreCaseAndPriceLessThanEqual(brand, colour, price), HttpStatus.OK);
                    }
                } else if (counter == 2) {
                    return new ResponseEntity<>(carRepository.findByBodyTypeAndPriceLessThanEqual(bodyType, price), HttpStatus.OK);
                }
            case 9:
                if (counter == 2) {
                    return new ResponseEntity<>(carRepository.findByCarYearGreaterThanEqualAndPriceLessThanEqual(year, price), HttpStatus.OK);
                } else if (counter == 3) {
                    if (colour == null) {
                        return new ResponseEntity<>(carRepository.findByBrandIgnoreCaseAndBodyTypeAndPriceLessThanEqual(brand, bodyType, price), HttpStatus.OK);
                    } else {
                        return new ResponseEntity<>(carRepository.findByColourIgnoreCaseAndBodyTypeAndCarYearGreaterThanEqual(colour, bodyType, year), HttpStatus.OK);
                    }
                } else if (counter == 4) {
                    return new ResponseEntity<>(carRepository.findByBrandIgnoreCaseAndColourIgnoreCaseAndBodyTypeAndCarYearGreaterThanEqual(brand, colour, bodyType, year), HttpStatus.OK);
                }
            case 10:
                if (counter == 3) {
                    if (brand == null) {
                        return new ResponseEntity<>(carRepository.findByColourIgnoreCaseAndBodyTypeAndPriceLessThanEqual(colour, bodyType, price), HttpStatus.OK);
                    } else {
                        return new ResponseEntity<>(carRepository.findByBrandIgnoreCaseAndCarYearGreaterThanEqualAndPriceLessThanEqual(brand, year, price), HttpStatus.OK);
                    }
                } else if (counter == 4) {
                    return new ResponseEntity<>(carRepository.findByBrandIgnoreCaseAndColourIgnoreCaseAndBodyTypeAndCarYearGreaterThanEqual(brand, colour, bodyType, year), HttpStatus.OK);
                }
            case 11:
                if (counter == 3) {
                    return new ResponseEntity<>(carRepository.findByColourIgnoreCaseAndCarYearGreaterThanEqualAndPriceLessThanEqual(colour, year, price), HttpStatus.OK);
                } else if (counter == 4) {
                    return new ResponseEntity<>(carRepository.findByBrandIgnoreCaseAndColourIgnoreCaseAndBodyTypeAndPriceLessThanEqual(brand, colour, bodyType, price), HttpStatus.OK);
                }
            case 12:
                if (counter == 3) {
                    return new ResponseEntity<>(carRepository.findByBodyTypeAndCarYearGreaterThanEqualAndPriceLessThanEqual(bodyType, year, price), HttpStatus.OK);
                } else if (counter == 4) {
                    return new ResponseEntity<>(carRepository.findByBrandIgnoreCaseAndColourIgnoreCaseAndCarYearGreaterThanEqualAndPriceLessThanEqual(brand, colour, year, price), HttpStatus.OK);
                }
            case 13:
                if (counter == 4) {
                    return new ResponseEntity<>(carRepository.findByBrandIgnoreCaseAndBodyTypeAndCarYearGreaterThanEqualAndPriceLessThanEqual(brand, bodyType, year, price), HttpStatus.OK);
                }
            case 14:
                if (counter == 4) {
                    return new ResponseEntity<>(carRepository.findByColourIgnoreCaseAndBodyTypeAndCarYearGreaterThanEqualAndPriceLessThanEqual(colour, bodyType, year, price), HttpStatus.OK);
                }
            case 15:
                if (counter == 5) {
                    return new ResponseEntity<>(carRepository.findByBrandIgnoreCaseAndColourIgnoreCaseAndBodyTypeAndCarYearGreaterThanEqualAndPriceLessThanEqual(brand, colour, bodyType, year, price), HttpStatus.OK);
                }
        }
        return new ResponseEntity<>(carRepository.findAll(), HttpStatus.OK);
    }

    // SHOW
    @GetMapping(value = "/{id}")
    public ResponseEntity<List<Car>> getCarById(@PathVariable Long id) {
        return new ResponseEntity(carRepository.findById(id), HttpStatus.OK);
    }

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
        return new ResponseEntity<>("Deleted Car ID: " + id, HttpStatus.NOT_FOUND);

    }
}
