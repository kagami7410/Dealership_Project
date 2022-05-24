package com.bnta.manual_trader.repositories;

import com.bnta.manual_trader.models.Bodytype;
import com.bnta.manual_trader.models.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.StreamingHttpOutputMessage;

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
    List<Car>findbyBrandAndColourAndPriceGreaterThan(String brand, String colour, Double price);
    List<Car> findByBrandAndColourAndBodyTypeAndCarYearGreaterThan(String brand, String colour, Bodytype bodytype, Integer year);
    List<Car> findByBrandAndColourAndBodyTypeAndPriceGreaterThan(String brand, String colour, Bodytype bodytype, Double price);
    List<Car> findByBrandAndColourAndBodyTypeAndCarYearGreaterThanAndPriceGreaterThan(String brand, String colour, Bodytype bodytype, Integer year, Double price);
    List<Car> findByBrandAndColourAndCarYearGreaterThan(String brand, String colour, Integer year);

    List<Car> findByBodyTypeAndCarYearGreaterThanAndPrice(Bodytype bodytype, Integer year, Double price);
    List<Car> findByBrandAndBodyTypeAndCarYearGreaterThan(String brand, Bodytype bodytype, Integer year);
    List<Car> findByBrandAndBodyTypeAndPriceGreaterThan(String brand, Bodytype bodytype, Double price);
    List<Car> findByBrandAndCarYearGreaterThanAndPriceGreaterThan(String brand, Integer year, Double price);

    List<Car> findByBrandAndColourAndCarYearGreaterThanAndPriceGreaterThan(String brand, String colour, Integer year, Double Price);
    List<Car> findByBrandAndBodyTypeAndCarYearGreaterThanAndPriceGreaterThan(String Brand, Bodytype bodytype, Integer year, Double Price);


    List<Car> findByColourAndBodyType(String colour, Bodytype bodytype);
    List<Car> findByColourAndCarYearGreaterThan(String colour, Integer year);
    List<Car> findByColourAndPriceGreaterThan(String colour, Double price);
    List<Car> findByColourAndBodyTypeAndCarYearGreaterThan(String colour, Bodytype bodytype, Integer year);
    List<Car> findByColourAndBodyTypeAndPriceGreaterThan(String colour, Bodytype bodytype, Double price);
    List<Car> findByColourAndBodyTypeAndCarYearGreaterThanAndPriceGreaterThan(String colour, Bodytype bodytype, Integer year, Double price);
    List<Car> findByColourAndCarYearGreaterThanAndPriceGreaterThan(String colour, Integer year, Double price);


    List<Car> findByBodyTypeAndCarYearGreaterThan(Bodytype bodytype, Integer year);
    List<Car> findByBodyTypeAndPriceGreaterThan(Bodytype bodyType, Double price);

    List<Car> findByBodyTypeAndYearGreaterThanAndPriceGreaterThan(Bodytype bodytype, Integer year, Double price);
    List<Car> findByCarYearGreaterThanAndPriceGreaterThan(Integer year, Double price);


















    List<Car> getAllCarsAndByBodyType(Bodytype bodyType);




}
