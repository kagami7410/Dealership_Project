package com.bnta.manual_trader.repositories;

import com.bnta.manual_trader.models.Bodytype;
import com.bnta.manual_trader.models.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {

    List<Car> findByBrand(String brand);
    List<Car> findByColour(String Colour);
    List<Car> findByCarYearGreaterThan(Integer carYear);
    List<Car> findByPriceGreaterThan(Double price);
    List<Car> findByBodyType(Bodytype bodytype);

    List<Car> findByBrandAndColour(String brand, String colour);
    List<Car> findByBrandAndBodyType(String brand, Bodytype bodyType);
    List<Car> findByBrandAndCarYearGreaterThan(String brand, Integer year);
    List<Car> findByBrandAndPriceGreaterThan(String brand, Double price);
    List<Car> findByBrandAndColourAndBodyType(String brand, String colour, Bodytype bodytype);
    List<Car> findByBrandAndColourAndBodyTypeAndCarYearGreaterThan(String brand, String colour, Bodytype bodytype, Integer year);
    List<Car> findByBrandAndColourAndBodyTypeAndCarYearGreaterThanAndPriceGreaterThan(String brand, String colour, Bodytype bodytype, Integer year, Double price);

    List<Car> findByColourAndBodyType(String colour, Bodytype bodytype);
    List<Car> findByColourAndCarYearGreaterThan(String colour, Integer year);
    List<Car> findByColourAndPriceGreaterThan(String colour, Integer price);
    List<Car> findByColourAndBodyTypeAndCarYearGreaterThan(String colour, Bodytype bodytype, Integer year);
    List<Car> findByColourAndBodyTypeAndCarYearGreaterThanAndPriceGreaterThan(String colour, Bodytype bodytype, Integer year, Double price);

    List<Car> findByBodyTypeAndCarYearGreaterThanAndPrice(Bodytype bodytype, Integer year, Double price);
    List<Car> findByBrandAndBodyTypeAndCarYearGreaterThan(String brand, Bodytype bodytype, Integer year);
    List<Car> findByBodyTypeAndCarYearGreaterThan(Bodytype bodytype, Integer year);

















    List<Car> getAllCarsAndByBodyType(Bodytype bodyType);




}
