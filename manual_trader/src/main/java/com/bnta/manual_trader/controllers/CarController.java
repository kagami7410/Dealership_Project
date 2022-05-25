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

//        if (brand != null && colour != null && bodyType != null && year != null && price != null) {
//            return new ResponseEntity<>(carRepository.findByBrandAndColourAndBodyTypeAndCarYearGreaterThanEqualAndPriceLessThanEqual(
//                    brand, colour, bodyType, year, price), HttpStatus.OK);
//        } else if (brand != null && colour != null && bodyType != null && year != null && price == null) {
//            return new ResponseEntity<>(carRepository.findByBrandAndColourAndBodyTypeAndCarYearGreaterThanEqual(
//                    brand, colour, bodyType, year), HttpStatus.OK);
//        } else if (brand != null && colour != null && bodyType != null && year == null && price != null) {
//            return new ResponseEntity<>(carRepository.findByBrandAndColourAndBodyTypeAndPriceLessThanEqual(
//                    brand, colour, bodyType, price), HttpStatus.OK);
//        } else if (brand != null && colour != null && bodyType == null && year != null && price != null) {
//            return new ResponseEntity<>(carRepository.findByBrandAndColourAndCarYearGreaterThanEqualAndPriceLessThanEqual(
//                    brand, colour, year, price), HttpStatus.OK);
//        } else if (brand != null && colour == null && bodyType != null && year != null && price != null) {
//            return new ResponseEntity<>(carRepository.findByBrandAndBodyTypeAndCarYearGreaterThanEqualAndPriceLessThanEqual(
//                    brand, bodyType, year, price), HttpStatus.OK);
//        } else if (brand == null && colour != null && bodyType != null && year != null && price != null) {
//            return new ResponseEntity<>(carRepository.findByColourAndBodyTypeAndCarYearGreaterThanEqualAndPriceLessThanEqual(
//                    colour, bodyType, year, price), HttpStatus.OK);
//        } else if (brand == null && colour == null && bodyType != null && year != null && price != null) {
//            return new ResponseEntity<>(carRepository.findByBodyTypeAndCarYearGreaterThanEqualAndPriceLessThanEqual(
//                    bodyType, year, price), HttpStatus.OK);
//        } else if (brand == null && colour != null && bodyType == null && year != null && price != null) {
//            return new ResponseEntity<>(carRepository.findByColourAndCarYearGreaterThanEqualAndPriceLessThanEqual(
//                    colour, year, price), HttpStatus.OK);
//        } else if (brand == null && colour != null && bodyType != null && year == null && price != null) {
//            return new ResponseEntity<>(carRepository.findByColourAndBodyTypeAndPriceLessThanEqual(
//                    colour, bodyType, price), HttpStatus.OK);
//        } else if (brand == null && colour != null && bodyType != null && year != null && price == null) {
//            return new ResponseEntity<>(carRepository.findByColourAndBodyTypeAndCarYearGreaterThanEqual(
//                    colour, bodyType, year), HttpStatus.OK);
//        } else if (brand != null && colour == null && bodyType == null && year != null && price != null) {
//            return new ResponseEntity<>(carRepository.findByBrandAndCarYearGreaterThanEqualAndPriceLessThanEqual(
//                    brand, year, price), HttpStatus.OK);
//        } else if (brand != null && colour == null && bodyType != null && year == null && price != null) {
//            return new ResponseEntity<>(carRepository.findByBrandAndBodyTypeAndPriceLessThanEqual(
//                    brand, bodyType, price), HttpStatus.OK);
//        } else if (brand != null && colour == null && bodyType != null && year != null && price == null) {
//            return new ResponseEntity<>(carRepository.findByBrandAndBodyTypeAndCarYearGreaterThanEqual(
//                    brand, bodyType, year), HttpStatus.OK);
//        } else if (brand != null && colour != null && bodyType == null && year == null && price != null) {
//            return new ResponseEntity<>(carRepository.findByBrandAndColourAndPriceLessThanEqual(
//                    brand, colour, price), HttpStatus.OK);
//        } else if (brand != null && colour != null && bodyType == null && year != null && price == null) {
//            return new ResponseEntity<>(carRepository.findByBrandAndColourAndCarYearGreaterThanEqual(
//                    brand, colour, year), HttpStatus.OK);
//        } else if (brand != null && colour != null && bodyType != null && year == null && price == null) {
//            return new ResponseEntity<>(carRepository.findByBrandAndColourAndBodyType(
//                    brand, colour, bodyType), HttpStatus.OK);
//        } else if (brand != null && colour != null && bodyType == null && year == null && price == null) {
//            return new ResponseEntity<>(carRepository.findByBrandAndColour(
//                    brand, colour), HttpStatus.OK);
//        } else if (brand != null && colour == null && bodyType != null && year == null && price == null) {
//            return new ResponseEntity<>(carRepository.findByBrandAndBodyType(
//                    brand, bodyType), HttpStatus.OK);
//        } else if (brand != null && colour == null && bodyType == null && year != null && price == null) {
//            return new ResponseEntity<>(carRepository.findByBrandAndCarYearGreaterThanEqual(
//                    brand, year), HttpStatus.OK);
//        } else if (brand != null && colour == null && bodyType == null && year == null && price != null) {
//            return new ResponseEntity<>(carRepository.findByBrandAndPriceLessThanEqual(
//                    brand, price), HttpStatus.OK);
//        } else if (brand == null && colour != null && bodyType != null && year == null && price == null) {
//            return new ResponseEntity<>(carRepository.findByColourAndBodyType(
//                    colour, bodyType), HttpStatus.OK);
//        } else if (brand == null && colour != null && bodyType == null && year != null && price == null) {
//            return new ResponseEntity<>(carRepository.findByColourAndCarYearGreaterThanEqual(
//                    colour, year), HttpStatus.OK);
//        } else if (brand == null && colour != null && bodyType == null && year == null && price != null) {
//            return new ResponseEntity<>(carRepository.findByColourAndPriceLessThanEqual(
//                    colour, price), HttpStatus.OK);
//        } else if (brand == null && colour == null && bodyType != null && year != null && price == null) {
//            return new ResponseEntity<>(carRepository.findByBodyTypeAndCarYearGreaterThanEqual(
//                    bodyType, year), HttpStatus.OK);
//        } else if (brand == null && colour == null && bodyType != null && year == null && price != null) {
//            return new ResponseEntity<>(carRepository.findByBodyTypeAndPriceLessThanEqual(
//                    bodyType, price), HttpStatus.OK);
//        } else if (brand == null && colour == null && bodyType == null && year != null && price != null) {
//            return new ResponseEntity<>(carRepository.findByCarYearGreaterThanEqualAndPriceLessThanEqual(
//                    year, price), HttpStatus.OK);
//        } else if (brand != null && colour == null && bodyType == null && year == null && price == null) {
//            return new ResponseEntity<>(carRepository.findByBrand(brand), HttpStatus.OK);
//        } else if (brand == null && colour != null && bodyType == null && year == null && price == null) {
//            return new ResponseEntity<>(carRepository.findByColour(colour), HttpStatus.OK);
//        } else if (brand == null && colour == null && bodyType != null && year == null && price == null) {
//            return new ResponseEntity<>(carRepository.findByBodyType(bodyType), HttpStatus.OK);
//        } else if (brand == null && colour == null && bodyType == null && year != null && price == null) {
//            return new ResponseEntity<>(carRepository.findByCarYearGreaterThanEqual(year), HttpStatus.OK);
//        } else if (brand == null && colour == null && bodyType == null && year == null && price != null) {
//            return new ResponseEntity<>(carRepository.findByPriceLessThanEqual(price), HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(carRepository.findAll(), HttpStatus.OK);
//        }


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
                return new ResponseEntity<>(carRepository.findByBrand(brand), HttpStatus.OK);
            case 2:
                return new ResponseEntity<>(carRepository.findByColour(colour), HttpStatus.OK);
            case 3:
                if (counter != 2) {
                    return new ResponseEntity<>(carRepository.findByBodyType(bodyType), HttpStatus.OK);
                } else {
                    return new ResponseEntity<>(carRepository.findByBrandAndColour(brand, colour), HttpStatus.OK);
                }
            case 4:
                if (counter != 2) {
                    return new ResponseEntity<>(carRepository.findByCarYearGreaterThanEqual(year), HttpStatus.OK);
                } else {
                    return new ResponseEntity<>(carRepository.findByBrandAndBodyType(brand, bodyType), HttpStatus.OK);
                }
            case 5:
                if (counter == 2) {
                    if (brand == null) {
                        return new ResponseEntity<>(carRepository.findByColourAndBodyType(colour, bodyType), HttpStatus.OK);
                    } else {
                        return new ResponseEntity<>(carRepository.findByBrandAndCarYearGreaterThanEqual(brand, year), HttpStatus.OK);
                    }
                } else if (counter == 1) {
                    return new ResponseEntity<>(carRepository.findByPriceLessThanEqual(price), HttpStatus.OK);
                }
            case 6:
                if (counter == 2) {
                    if (bodyType == null) {
                        return new ResponseEntity<>(carRepository.findByBrandAndPriceLessThanEqual(brand, price), HttpStatus.OK);
                    } else {
                        return new ResponseEntity<>(carRepository.findByColourAndCarYearGreaterThanEqual(colour, year), HttpStatus.OK);
                    }
                } else if (counter == 3) {
                    return new ResponseEntity<>(carRepository.findByBrandAndColourAndBodyType(brand, colour, bodyType), HttpStatus.OK);
                }
            case 7:
                if (counter == 3) {
                    return new ResponseEntity<>(carRepository.findByBrandAndColourAndCarYearGreaterThanEqual(brand, colour, year), HttpStatus.OK);
                }
                if (counter == 2) {
                    if (bodyType == null) {
                        return new ResponseEntity<>(carRepository.findByColourAndPriceLessThanEqual(colour, price), HttpStatus.OK);
                    } else {
                        return new ResponseEntity<>(carRepository.findByBodyTypeAndCarYearGreaterThanEqual(bodyType, year), HttpStatus.OK);
                    }
                }
            case 8:
                if (counter == 3) {
                    if (colour == null) {
                        return new ResponseEntity<>(carRepository.findByBrandAndBodyTypeAndCarYearGreaterThanEqual(brand, bodyType, year), HttpStatus.OK);
                    } else {
                        return new ResponseEntity<>(carRepository.findByBrandAndColourAndPriceLessThanEqual(brand, colour, price), HttpStatus.OK);
                    }
                } else if (counter == 2) {
                    return new ResponseEntity<>(carRepository.findByBodyTypeAndPriceLessThanEqual(bodyType, price), HttpStatus.OK);
                }
            case 9:
                if (counter == 2) {
                    return new ResponseEntity<>(carRepository.findByCarYearGreaterThanEqualAndPriceLessThanEqual(year, price), HttpStatus.OK);
                } else if (counter == 3) {
                    if (colour == null) {
                        return new ResponseEntity<>(carRepository.findByBrandAndBodyTypeAndPriceLessThanEqual(brand, bodyType, price), HttpStatus.OK);
                    } else {
                        return new ResponseEntity<>(carRepository.findByColourAndBodyTypeAndCarYearGreaterThanEqual(colour, bodyType, year), HttpStatus.OK);
                    }
                } else if (counter == 4) {
                    return new ResponseEntity<>(carRepository.findByBrandAndColourAndBodyTypeAndCarYearGreaterThanEqual(brand, colour, bodyType, year), HttpStatus.OK);
                }
            case 10:
                if (counter == 3) {
                    if (brand == null) {
                        return new ResponseEntity<>(carRepository.findByColourAndBodyTypeAndPriceLessThanEqual(colour, bodyType, price), HttpStatus.OK);
                    } else {
                        return new ResponseEntity<>(carRepository.findByBrandAndCarYearGreaterThanEqualAndPriceLessThanEqual(brand, year, price), HttpStatus.OK);
                    }
                } else if (counter == 4) {
                    return new ResponseEntity<>(carRepository.findByBrandAndColourAndBodyTypeAndCarYearGreaterThanEqual(brand, colour, bodyType, year), HttpStatus.OK);
                }
            case 11:
                if (counter == 3) {
                    return new ResponseEntity<>(carRepository.findByColourAndCarYearGreaterThanEqualAndPriceLessThanEqual(colour, year, price), HttpStatus.OK);
                } else if (counter == 4) {
                    return new ResponseEntity<>(carRepository.findByBrandAndColourAndBodyTypeAndPriceLessThanEqual(brand, colour, bodyType, price), HttpStatus.OK);
                }
            case 12:
                if (counter == 3) {
                    return new ResponseEntity<>(carRepository.findByBodyTypeAndCarYearGreaterThanEqualAndPriceLessThanEqual(bodyType, year, price), HttpStatus.OK);
                } else if (counter == 4) {
                    return new ResponseEntity<>(carRepository.findByBrandAndColourAndCarYearGreaterThanEqualAndPriceLessThanEqual(brand, colour, year, price), HttpStatus.OK);
                }
            case 13:
                if (counter == 4) {
                    return new ResponseEntity<>(carRepository.findByBrandAndBodyTypeAndCarYearGreaterThanEqualAndPriceLessThanEqual(brand, bodyType, year, price), HttpStatus.OK);
                }
            case 14:
                if (counter == 4) {
                    return new ResponseEntity<>(carRepository.findByColourAndBodyTypeAndCarYearGreaterThanEqualAndPriceLessThanEqual(colour, bodyType, year, price), HttpStatus.OK);
                }
            case 15:
                if (counter == 5) {
                    return new ResponseEntity<>(carRepository.findByBrandAndColourAndBodyTypeAndCarYearGreaterThanEqualAndPriceLessThanEqual(brand, colour, bodyType, year, price), HttpStatus.OK);
                }
        }
        return new ResponseEntity<>(carRepository.findAll(), HttpStatus.OK);
    }


//    // GET byBrand
//    @GetMapping
//    public ResponseEntity<List<Car>> getAllCarsAndByBrand(@RequestParam(required = false, name = "brand") String brand) {
//        if (brand != null) {
//            return new ResponseEntity(carRepository.findByBrand(brand), HttpStatus.OK);
//        }
//        return new ResponseEntity(carRepository.findAll(), HttpStatus.OK);
//    }
//
//    // GET byBodyType
//    @GetMapping
//    public ResponseEntity<List<Car>> getAllCarsAndByBodyType(@RequestParam(required = false, name = "bodyType") Bodytype bodyType) {
//        if (bodyType != null) {
//            return new ResponseEntity(carRepository.findByBodyType(bodyType), HttpStatus.OK);
//        }
//        return new ResponseEntity(carRepository.findAll(), HttpStatus.OK);
//    }
//
//    // GET byColour
//    @GetMapping
//    public ResponseEntity<List<Car>> getAllCarsAndByColour(@RequestParam(required = false, name = "colour") String colour) {
//        if (colour != null) {
//            return new ResponseEntity(carRepository.findByColour(colour), HttpStatus.OK);
//        }
//        return new ResponseEntity(carRepository.findAll(), HttpStatus.OK);
//    }
//    // GET byYear
//
//
//    // GET byPrice
//    @GetMapping
//    public ResponseEntity<List<Car>> findByPriceGreaterThan(@RequestParam(required = false, name = "price") Double price) {
//        if (price != null) {
//            return new ResponseEntity(carRepository.findByPriceGreaterThan(price), HttpStatus.OK);
//        }
//        return new ResponseEntity(carRepository.findAll(), HttpStatus.OK);
//    }


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
        return new ResponseEntity<>("Deleted Car ID: " + id, HttpStatus.NOT_FOUND);

    }
}
