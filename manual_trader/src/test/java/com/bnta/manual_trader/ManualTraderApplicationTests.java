package com.bnta.manual_trader;

import com.bnta.manual_trader.models.Bodytype;
import com.bnta.manual_trader.models.Car;
import com.bnta.manual_trader.repositories.CarRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@SpringBootTest
class ManualTraderApplicationTests {

    @Autowired
    CarRepository carRepository;

    @Test
    void contextLoads() {
    }

    @Test
    public void canFindCarByBrand() {
        List<Car> carFoundByBrand = carRepository.findByBrandIgnoreCase("BMW");
        assertThat(carFoundByBrand.size()).isEqualTo(1);
    }

    @Test
    public void canFindCarByBodyType() {
        List<Car> carFoundByBodyType = carRepository.findByBodyType(Bodytype.CONVERTIBLE);
        assertThat(carFoundByBodyType.size()).isEqualTo(3);
    }

    @Test
    public void canFindCarByPriceGreaterThan() {
        List<Car> carFoundByPriceGreaterThan = carRepository.findByPriceLessThanEqual(10000.00);
        assertThat(carFoundByPriceGreaterThan.size()).isEqualTo(17);
    }

    @Test
    public void canFindCarByCarYearGreaterThan() {
        List<Car> carFoundByCarYear = carRepository.findByCarYearGreaterThanEqual(2020);
        assertThat(carFoundByCarYear.size()).isEqualTo(3);
    }

    @Test
    public void canFindCarByColour() {
        List<Car> carFoundByColour = carRepository.findByColour("Red");
        assertThat(carFoundByColour.size()).isEqualTo(3);
    }


//    if (brand != null && colour != null && bodyType != null && year != null && price != null) {
//        return new ResponseEntity<>(carRepository.findByBrandAndColourAndBodyTypeAndCarYearGreaterThanEqualAndPriceGreaterThanEqual(
//                brand, colour, bodyType, year, price), HttpStatus.OK);
//    } else if (brand != null && colour != null && bodyType != null && year != null && price == null) {
//        return new ResponseEntity<>(carRepository.findByBrandAndColourAndBodyTypeAndCarYearGreaterThanEqual(
//                brand, colour, bodyType, year), HttpStatus.OK);
//    } else if (brand != null && colour != null && bodyType != null && year == null && price != null) {
//        return new ResponseEntity<>(carRepository.findByBrandAndColourAndBodyTypeAndPriceGreaterThanEqual(
//                brand, colour, bodyType, price), HttpStatus.OK);
//    } else if (brand != null && colour != null && bodyType == null && year != null && price != null) {
//        return new ResponseEntity<>(carRepository.findByBrandAndColourAndCarYearGreaterThanEqualAndPriceGreaterThanEqual(
//                brand, colour, year, price), HttpStatus.OK);
//    } else if (brand != null && colour == null && bodyType != null && year != null && price != null) {
//        return new ResponseEntity<>(carRepository.findByBrandAndBodyTypeAndCarYearGreaterThanEqualAndPriceGreaterThanEqual(
//                brand, bodyType, year, price), HttpStatus.OK);
//    } else if (brand == null && colour != null && bodyType != null && year != null && price != null) {
//        return new ResponseEntity<>(carRepository.findByColourAndBodyTypeAndCarYearGreaterThanEqualAndPriceGreaterThanEqual(
//                colour, bodyType, year, price), HttpStatus.OK);
//    } else if (brand == null && colour == null && bodyType != null && year != null && price != null) {
//        return new ResponseEntity<>(carRepository.findByBodyTypeAndCarYearGreaterThanEqualAndPriceGreaterThanEqual(
//                bodyType, year, price), HttpStatus.OK);
//    } else if (brand == null && colour != null && bodyType == null && year != null && price != null) {
//        return new ResponseEntity<>(carRepository.findByColourAndCarYearGreaterThanEqualAndPriceGreaterThanEqual(
//                colour, year, price), HttpStatus.OK);
//    } else if (brand == null && colour != null && bodyType != null && year == null && price != null) {
//        return new ResponseEntity<>(carRepository.findByColourAndBodyTypeAndPriceGreaterThanEqual(
//                colour, bodyType, price), HttpStatus.OK);
//    } else if (brand == null && colour != null && bodyType != null && year != null && price == null) {
//        return new ResponseEntity<>(carRepository.findByColourAndBodyTypeAndCarYearGreaterThanEqual(
//                colour, bodyType, year), HttpStatus.OK);
//    } else if (brand != null && colour == null && bodyType == null && year != null && price != null) {
//        return new ResponseEntity<>(carRepository.findByBrandAndCarYearGreaterThanEqualAndPriceGreaterThanEqual(
//                brand, year, price), HttpStatus.OK);
//    } else if (brand != null && colour == null && bodyType != null && year == null && price != null) {
//        return new ResponseEntity<>(carRepository.findByBrandAndBodyTypeAndPriceGreaterThanEqual(
//                brand, bodyType, price), HttpStatus.OK);
//    } else if (brand != null && colour == null && bodyType != null && year != null && price == null) {
//        return new ResponseEntity<>(carRepository.findByBrandAndBodyTypeAndCarYearGreaterThanEqual(
//                brand, bodyType, year), HttpStatus.OK);
//    } else if (brand != null && colour != null && bodyType == null && year == null && price != null) {
//        return new ResponseEntity<>(carRepository.findByBrandAndColourAndPriceGreaterThanEqual(
//                brand, colour, price), HttpStatus.OK);
//    } else if (brand != null && colour != null && bodyType == null && year != null && price == null) {
//        return new ResponseEntity<>(carRepository.findByBrandAndColourAndCarYearGreaterThanEqual(
//                brand, colour, year), HttpStatus.OK);
//    } else if (brand != null && colour != null && bodyType != null && year == null && price == null) {
//        return new ResponseEntity<>(carRepository.findByBrandAndColourAndBodyType(
//                brand, colour, bodyType), HttpStatus.OK);
//    } else if (brand != null && colour != null && bodyType == null && year == null && price == null) {
//        return new ResponseEntity<>(carRepository.findByBrandAndColour(
//                brand, colour), HttpStatus.OK);
//    } else if (brand != null && colour == null && bodyType != null && year == null && price == null) {
//        return new ResponseEntity<>(carRepository.findByBrandAndBodyType(
//                brand, bodyType), HttpStatus.OK);
//    } else if (brand != null && colour == null && bodyType == null && year != null && price == null) {
//        return new ResponseEntity<>(carRepository.findByBrandAndCarYearGreaterThanEqual(
//                brand, year), HttpStatus.OK);
//    } else if (brand != null && colour == null && bodyType == null && year == null && price != null) {
//        return new ResponseEntity<>(carRepository.findByBrandAndPriceGreaterThanEqual(
//                brand, price), HttpStatus.OK);
//    } else if (brand == null && colour != null && bodyType != null && year == null && price == null) {
//        return new ResponseEntity<>(carRepository.findByColourAndBodyType(
//                colour, bodyType), HttpStatus.OK);
//    } else if (brand == null && colour != null && bodyType == null && year != null && price == null) {
//        return new ResponseEntity<>(carRepository.findByColourAndCarYearGreaterThanEqual(
//                colour, year), HttpStatus.OK);
//    } else if (brand == null && colour != null && bodyType == null && year == null && price != null) {
//        return new ResponseEntity<>(carRepository.findByColourAndPriceGreaterThanEqual(
//                colour, price), HttpStatus.OK);
//    } else if (brand == null && colour == null && bodyType != null && year != null && price == null) {
//        return new ResponseEntity<>(carRepository.findByBodyTypeAndCarYearGreaterThanEqual(
//                bodyType, year), HttpStatus.OK);
//    } else if (brand == null && colour == null && bodyType != null && year == null && price != null) {
//        return new ResponseEntity<>(carRepository.findByBodyTypeAndPriceGreaterThanEqual(
//                bodyType, price), HttpStatus.OK);
//    } else if (brand == null && colour == null && bodyType == null && year != null && price != null) {
//        return new ResponseEntity<>(carRepository.findByCarYearGreaterThanEqualAndPriceGreaterThanEqual(
//                year, price), HttpStatus.OK);
//    } else if (brand != null && colour == null && bodyType == null && year == null && price == null) {
//        return new ResponseEntity<>(carRepository.findByBrand(brand), HttpStatus.OK);
//    } else if (brand == null && colour != null && bodyType == null && year == null && price == null) {
//        return new ResponseEntity<>(carRepository.findByColour(colour), HttpStatus.OK);
//    } else if (brand == null && colour == null && bodyType != null && year == null && price == null) {
//        return new ResponseEntity<>(carRepository.findByBodyType(bodyType), HttpStatus.OK);
//    } else if (brand == null && colour == null && bodyType == null && year != null && price == null) {
//        return new ResponseEntity<>(carRepository.findByCarYearGreaterThanEqual(year), HttpStatus.OK);
//    } else if (brand == null && colour == null && bodyType == null && year == null && price != null) {
//        return new ResponseEntity<>(carRepository.findByPriceGreaterThanEqual(price), HttpStatus.OK);
//    } else {
//        return new ResponseEntity<>(carRepository.findAll(), HttpStatus.OK);
//    }

}
