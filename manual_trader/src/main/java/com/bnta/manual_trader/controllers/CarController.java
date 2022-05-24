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

        if (brand != null && colour != null && bodyType != null && year != null && price != null) {
            return new ResponseEntity<>(carRepository.findByBrandAndColourAndBodyTypeAndCarYearGreaterThanEqualAndPriceGreaterThanEqual(
                    brand, colour, bodyType, year, price), HttpStatus.OK);
        } else if (brand != null && colour != null && bodyType != null && year != null && price == null) {
            return new ResponseEntity<>(carRepository.findByBrandAndColourAndBodyTypeAndCarYearGreaterThanEqual(
                    brand, colour, bodyType, year), HttpStatus.OK);
        } else if (brand != null && colour != null && bodyType != null && year == null && price != null) {
            return new ResponseEntity<>(carRepository.findByBrandAndColourAndBodyTypeAndPriceGreaterThanEqual(
                    brand, colour, bodyType, price), HttpStatus.OK);
        } else if (brand != null && colour != null && bodyType == null && year != null && price != null) {
            return new ResponseEntity<>(carRepository.findByBrandAndColourAndCarYearGreaterThanEqualAndPriceGreaterThanEqual(
                    brand, colour, year, price), HttpStatus.OK);
        } else if (brand != null && colour == null && bodyType != null && year != null && price != null) {
            return new ResponseEntity<>(carRepository.findByBrandAndBodyTypeAndCarYearGreaterThanEqualAndPriceGreaterThanEqual(
                    brand, bodyType, year, price), HttpStatus.OK);
        } else if (brand == null && colour != null && bodyType != null && year != null && price != null) {
            return new ResponseEntity<>(carRepository.findByColourAndBodyTypeAndCarYearGreaterThanEqualAndPriceGreaterThanEqual(
                    colour, bodyType, year, price), HttpStatus.OK);
        } else if (brand == null && colour == null && bodyType != null && year != null && price != null) {
            return new ResponseEntity<>(carRepository.findByBodyTypeAndCarYearGreaterThanEqualAndPriceGreaterThanEqual(
                    bodyType, year, price), HttpStatus.OK);
        } else if (brand == null && colour != null && bodyType == null && year != null && price != null) {
            return new ResponseEntity<>(carRepository.findByColourAndCarYearGreaterThanEqualAndPriceGreaterThanEqual(
                    colour, year, price), HttpStatus.OK);
        } else if (brand == null && colour != null && bodyType != null && year == null && price != null) {
            return new ResponseEntity<>(carRepository.findByColourAndBodyTypeAndPriceGreaterThanEqual(
                    colour, bodyType, price), HttpStatus.OK);
        } else if (brand == null && colour != null && bodyType != null && year != null && price == null) {
            return new ResponseEntity<>(carRepository.findByColourAndBodyTypeAndCarYearGreaterThanEqual(
                    colour, bodyType, year), HttpStatus.OK);
        } else if (brand != null && colour == null && bodyType == null && year != null && price != null) {
            return new ResponseEntity<>(carRepository.findByBrandAndCarYearGreaterThanEqualAndPriceGreaterThanEqual(
                    brand, year, price), HttpStatus.OK);
        } else if (brand != null && colour == null && bodyType != null && year == null && price != null) {
            return new ResponseEntity<>(carRepository.findByBrandAndBodyTypeAndPriceGreaterThanEqual(
                    brand, bodyType, price), HttpStatus.OK);
        } else if (brand != null && colour == null && bodyType != null && year != null && price == null) {
            return new ResponseEntity<>(carRepository.findByBrandAndBodyTypeAndCarYearGreaterThanEqual(
                    brand, bodyType, year), HttpStatus.OK);
        } else if (brand != null && colour != null && bodyType == null && year == null && price != null) {
            return new ResponseEntity<>(carRepository.findByBrandAndColourAndPriceGreaterThanEqual(
                    brand, colour, price), HttpStatus.OK);
        } else if (brand != null && colour != null && bodyType == null && year != null && price == null) {
            return new ResponseEntity<>(carRepository.findByBrandAndColourAndCarYearGreaterThanEqual(
                    brand, colour, year), HttpStatus.OK);
        } else if (brand != null && colour != null && bodyType != null && year == null && price == null) {
            return new ResponseEntity<>(carRepository.findByBrandAndColourAndBodyType(
                    brand, colour, bodyType), HttpStatus.OK);
        } else if (brand != null && colour != null && bodyType == null && year == null && price == null) {
            return new ResponseEntity<>(carRepository.findByBrandAndColour(
                    brand, colour), HttpStatus.OK);
        } else if (brand != null && colour == null && bodyType != null && year == null && price == null) {
            return new ResponseEntity<>(carRepository.findByBrandAndBodyType(
                    brand, bodyType), HttpStatus.OK);
        } else if (brand != null && colour == null && bodyType == null && year != null && price == null) {
            return new ResponseEntity<>(carRepository.findByBrandAndCarYearGreaterThanEqual(
                    brand, year), HttpStatus.OK);
        } else if (brand != null && colour == null && bodyType == null && year == null && price != null) {
            return new ResponseEntity<>(carRepository.findByBrandAndPriceGreaterThanEqual(
                    brand, price), HttpStatus.OK);
        } else if (brand == null && colour != null && bodyType != null && year == null && price == null) {
            return new ResponseEntity<>(carRepository.findByColourAndBodyType(
                    colour, bodyType), HttpStatus.OK);
        } else if (brand == null && colour != null && bodyType == null && year != null && price == null) {
            return new ResponseEntity<>(carRepository.findByColourAndCarYearGreaterThanEqual(
                    colour, year), HttpStatus.OK);
        } else if (brand == null && colour != null && bodyType == null && year == null && price != null) {
            return new ResponseEntity<>(carRepository.findByColourAndPriceGreaterThanEqual(
                    colour, price), HttpStatus.OK);
        } else if (brand == null && colour == null && bodyType != null && year != null && price == null) {
            return new ResponseEntity<>(carRepository.findByBodyTypeAndCarYearGreaterThanEqual(
                    bodyType, year), HttpStatus.OK);
        } else if (brand == null && colour == null && bodyType != null && year == null && price != null) {
            return new ResponseEntity<>(carRepository.findByBodyTypeAndPriceGreaterThanEqual(
                    bodyType, price), HttpStatus.OK);
        } else if (brand == null && colour == null && bodyType == null && year != null && price != null) {
            return new ResponseEntity<>(carRepository.findByCarYearGreaterThanEqualAndPriceGreaterThanEqual(
                    year, price), HttpStatus.OK);
        } else if (brand != null && colour == null && bodyType == null && year == null && price == null) {
            return new ResponseEntity<>(carRepository.findByBrand(brand), HttpStatus.OK);
        } else if (brand == null && colour != null && bodyType == null && year == null && price == null) {
            return new ResponseEntity<>(carRepository.findByColour(colour), HttpStatus.OK);
        } else if (brand == null && colour == null && bodyType != null && year == null && price == null) {
            return new ResponseEntity<>(carRepository.findByBodyType(bodyType), HttpStatus.OK);
        } else if (brand == null && colour == null && bodyType == null && year != null && price == null) {
            return new ResponseEntity<>(carRepository.findByCarYearGreaterThanEqual(year), HttpStatus.OK);
        } else if (brand == null && colour == null && bodyType == null && year == null && price != null) {
            return new ResponseEntity<>(carRepository.findByPriceGreaterThanEqual(price), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(carRepository.findAll(), HttpStatus.OK);
        }

    }
//        List listOfRequest = List.of(brand, colour, bodyType, year, price);
//        List<Integer> listOfCorrespondingNumber = List.of(1, 2, 3, 4, 5);
//        int requestScore = 0;
//        int counter = 0;
//
//        for (int i = 0; i < listOfRequest.size(); i++) {
//            if (listOfRequest.get(i) != null) {
//                requestScore = listOfCorrespondingNumber.get(i);
//                requestScore += requestScore;
//                counter += 1;
//            }
//
//            switch (requestScore) {
//                case 1:
//                    return new ResponseEntity<>(carRepository.findByBrand(brand), HttpStatus.OK);
//
//                case 2:
//                    return new ResponseEntity<>(carRepository.findByColour(colour), HttpStatus.OK);
//
//                case 3:
//                    if (counter != 2) {
//                        return new ResponseEntity<>(carRepository.findByBodyType(bodyType), HttpStatus.OK);
//                    } else {
//                        return new ResponseEntity<>(carRepository.findByBrandAndColour(brand, colour), HttpStatus.OK);
//                    }
//                case 4:
//                    if (counter != 2) {
//                        return new ResponseEntity<>(carRepository.findByCarYearGreaterThan(year), HttpStatus.OK);
//                    } else {
//                        return new ResponseEntity<>(carRepository.findByBrandAndBodyType(brand, bodyType), HttpStatus.OK);
//                    }
//                case 5:
//                    if (counter == 2) {
//                        return new ResponseEntity<>(carRepository.findByColourAndBodyType(colour, bodyType), HttpStatus.OK);
//                    } else if (counter == 1) {
//                        return new ResponseEntity<>(carRepository.findByBrandAndCarYearGreaterThan(brand, year), HttpStatus.OK);
//                    } else {
//                        return new ResponseEntity<>(carRepository.findByBrandAndColourAndBodyType(brand, colour, bodyType), HttpStatus.OK);
//                    }
//                case 6:
//                    if (counter == 2) {
//                        if (listOfRequest.get(2).equals(null)) {
//                            return new ResponseEntity<>(carRepository.findByBrandAndPriceGreaterThan(brand, price), HttpStatus.OK);
//                        } else {
//                            return new ResponseEntity<>(carRepository.findByColourAndCarYearGreaterThan(colour, year), HttpStatus.OK);
//                        }
//                    }
//                case 7:
//                    if (counter == 3) {
//                        return new ResponseEntity<>(carRepository.findByBrandAndColourAndCarYearGreaterThan(brand, colour, year), HttpStatus.OK);
//                    }
//                    if (counter == 2) {
//                        if (listOfRequest.get(2).equals(null)) {
//                            return new ResponseEntity<>(carRepository.findByColourAndPriceGreaterThan(colour, price), HttpStatus.OK);
//                        } else {
//                            return new ResponseEntity<>(carRepository.findByBodyTypeAndCarYearGreaterThan(bodyType, year), HttpStatus.OK);
//                        }
//                    }
//                case 8:
//                    if (counter == 3) {
//                        if (listOfRequest.get(1).equals(null)) {
//                            return new ResponseEntity<>(carRepository.findByBrandAndBodyTypeAndCarYearGreaterThan(brand, bodyType, year), HttpStatus.OK);
//                        } else {
//                            return new ResponseEntity<>(carRepository.findByBrandAndColourAndPriceGreaterThan(brand, colour, price), HttpStatus.OK);
//                        }
//                    } else if (counter == 2) {
//                        return new ResponseEntity<>(carRepository.findByBodyTypeAndPriceGreaterThan(bodyType, price), HttpStatus.OK);
//
//                    }
//
//                case 9:
//                    if (counter == 2) {
//                        return new ResponseEntity<>(carRepository.findByCarYearGreaterThanAndPriceGreaterThan(year, price), HttpStatus.OK);
//                    } else if (counter == 3) {
//                        return new ResponseEntity<>(carRepository.findByBrandAndBodyTypeAndPriceGreaterThan(brand, bodyType, price), HttpStatus.OK);
//                    } else if (counter == 4) {
//                        return new ResponseEntity<>(carRepository.findByBrandAndColourAndBodyTypeAndCarYearGreaterThan(brand, colour, bodyType, year), HttpStatus.OK);
//                    }
//                case 10:
//                    if (counter == 3) {
//                        if (listOfRequest.get(0).equals(null)) {
//                            return new ResponseEntity<>(carRepository.findByColourAndBodyTypeAndPriceGreaterThan(colour, bodyType, price), HttpStatus.OK);
//                        } else {
//                            return new ResponseEntity<>(carRepository.findByBrandAndCarYearGreaterThanAndPriceGreaterThan(brand, year, price), HttpStatus.OK);
//                        }
//
//                    } else if (counter == 4) {
//                        return new ResponseEntity<>(carRepository.findByBrandAndColourAndBodyTypeAndCarYearGreaterThan(brand, colour, bodyType, year), HttpStatus.OK);
//
//                    }
//                case 11:
//                    if (counter == 3) {
//                        return new ResponseEntity<>(carRepository.findByColourAndCarYearGreaterThanAndPriceGreaterThan(colour, year, price), HttpStatus.OK);
//                    } else if (counter == 4) {
//                        return new ResponseEntity<>(carRepository.findByBrandAndColourAndBodyTypeAndPriceGreaterThan(brand, colour, bodyType, price), HttpStatus.OK);
//                    }
//
//                case 12:
//                    if (counter == 3) {
//                        return new ResponseEntity<>(carRepository.findByBodyTypeAndCarYearGreaterThanAndPriceGreaterThan(bodyType, year, price), HttpStatus.OK);
//                    } else if (counter == 4) {
//                        return new ResponseEntity<>(carRepository.findByBrandAndColourAndCarYearGreaterThanAndPriceGreaterThan(brand, colour, year, price), HttpStatus.OK);
//                    }
//                case 13:
//                    if (counter == 4) {
//                        return new ResponseEntity<>(carRepository.findByBrandAndBodyTypeAndCarYearGreaterThanAndPriceGreaterThan(brand, bodyType, year, price), HttpStatus.OK);
//                    }
//                case 14:
//                    if (counter == 4) {
//                        return new ResponseEntity<>(carRepository.findByColourAndBodyTypeAndCarYearGreaterThanAndPriceGreaterThan(colour, bodyType, year, price), HttpStatus.OK);
//                    }
//                case 15:
//                    if (counter == 5) {
//                        return new ResponseEntity<>(carRepository.findByBrandAndColourAndBodyTypeAndCarYearGreaterThanAndPriceGreaterThan(brand, colour, bodyType, year, price), HttpStatus.OK);
//                    }
//
//            }
//
//
//        }
//        return new ResponseEntity<>(carRepository.findAll(), HttpStatus.OK);
//    }


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
        return new ResponseEntity<>("Deleted", HttpStatus.NOT_FOUND);

    }
}
