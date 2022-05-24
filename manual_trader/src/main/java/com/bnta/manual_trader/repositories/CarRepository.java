package com.bnta.manual_trader.repositories;

import com.bnta.manual_trader.models.Bodytype;
import com.bnta.manual_trader.models.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {

    List<Car> findByBrand(String brand);
    List<Car> findByColour(String Colour);
    List<Car> findByCarYear(Integer carYear);


    List<Car> findByPrice(Double price);
    List<Car> findByPriceGreaterThan(Double price);
    List<Car> findByBodyType(Bodytype bodytype);

    List<Car> findByBrandAndColour(String brand, String colour);
    List<Car> findByBrandAndBodyType(String brand, Bodytype bodyType);
    List<Car> findByBrandAndYear(String brand, Integer year);
    List<Car> findByBrandAndfindByPriceGreaterThan(String brand, Double price);

    List<Car> findByBrandAndColourAndBodyType(String brand, String colour, Bodytype bodytype);
    List<Car> findByBrandAndColourAndBodyTypeAndYear(String brand, String colour, Bodytype bodytype, Integer year);

    List<Car> findByBrandAndColourAndBodyTypeAndYearAndPriceGreaterThan(String brand, String colour, Bodytype bodytype, Integer year, Double price);
    List<Car> findByColourAndBodyType(String colour, Bodytype bodytype);
    List<Car> findByColourAndYear(String colour, Integer year);
    List<Car> findByColourAndPriceGreaterThan(String colour, Integer price);
    List<Car> findByColourAndBodyTypeAndYear(String colour, Bodytype bodytype, Integer year);
    List<Car> findByColourAndBodyTypeAndYearAndPriceGreaterThan(String colour, Bodytype bodytype, Integer year, Double price);

    List<Car> findByBodyTypeAndYearAndPrice(Bodytype bodytype, Integer year, Double price);
    List<Car> findByBrandAndBodyTypeAndYear(String brand, Bodytype bodytype, Integer year);
    List<Car> findByBodyTypeAndYear(Bodytype bodytype, Integer year);

















    List<Car> getAllCarsAndByBodyType(Bodytype bodyType);




}
