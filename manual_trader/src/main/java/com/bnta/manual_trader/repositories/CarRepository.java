package com.bnta.manual_trader.repositories;

import com.bnta.manual_trader.models.Bodytype;
import com.bnta.manual_trader.models.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.StreamingHttpOutputMessage;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {

    List<Car> findByBrand(String brand);
    List<Car> findByColour(String Colour);
    List<Car> findByCarYearGreaterThanEqual(Integer carYear);
    List<Car> findByPriceLessThanEqual(Double price);
    List<Car> findByBodyType(Bodytype bodytype);


    List<Car> findByBrandAndColour(String brand, String colour);
    List<Car> findByBrandAndBodyType(String brand, Bodytype bodyType);
    List<Car> findByBrandAndCarYearGreaterThanEqual(String brand, Integer carYear);
    List<Car> findByBrandAndPriceLessThanEqual(String brand, Double price);
    List<Car> findByBrandAndColourAndBodyType(String brand, String colour, Bodytype bodytype);
    List<Car> findByBrandAndColourAndPriceLessThanEqual(String brand, String colour, Double price);
    List<Car> findByBrandAndColourAndBodyTypeAndCarYearGreaterThanEqual(String brand, String colour, Bodytype bodytype, Integer carYear);
    List<Car> findByBrandAndColourAndBodyTypeAndPriceLessThanEqual(String brand, String colour, Bodytype bodytype, Double price);
    List<Car> findByBrandAndColourAndBodyTypeAndCarYearGreaterThanEqualAndPriceLessThanEqual(String brand, String colour, Bodytype bodytype, Integer carYear, Double price);
    List<Car> findByBrandAndColourAndCarYearGreaterThanEqual(String brand, String colour, Integer carYear);

    List<Car> findByBrandAndBodyTypeAndCarYearGreaterThanEqual(String brand, Bodytype bodytype, Integer carYear);
    List<Car> findByBrandAndBodyTypeAndPriceLessThanEqual(String brand, Bodytype bodytype, Double price);
    List<Car> findByBrandAndCarYearGreaterThanEqualAndPriceLessThanEqual(String brand, Integer carYear, Double price);

    List<Car> findByBrandAndColourAndCarYearGreaterThanEqualAndPriceLessThanEqual(String brand, String colour, Integer carYear, Double Price);
    List<Car> findByBrandAndBodyTypeAndCarYearGreaterThanEqualAndPriceLessThanEqual(String Brand, Bodytype bodytype, Integer carYear, Double Price);


    List<Car> findByColourAndBodyType(String colour, Bodytype bodytype);
    List<Car> findByColourAndCarYearGreaterThanEqual(String colour, Integer carYear);
    List<Car> findByColourAndPriceLessThanEqual(String colour, Double price);
    List<Car> findByColourAndBodyTypeAndCarYearGreaterThanEqual(String colour, Bodytype bodytype, Integer carYear);
    List<Car> findByColourAndBodyTypeAndPriceLessThanEqual(String colour, Bodytype bodytype, Double price);
    List<Car> findByColourAndBodyTypeAndCarYearGreaterThanEqualAndPriceLessThanEqual(String colour, Bodytype bodytype, Integer carYear, Double price);
    List<Car> findByColourAndCarYearGreaterThanEqualAndPriceLessThanEqual(String colour, Integer carYear, Double price);


    List<Car> findByBodyTypeAndCarYearGreaterThanEqual(Bodytype bodytype, Integer carYear);
    List<Car> findByBodyTypeAndPriceLessThanEqual(Bodytype bodyType, Double price);

    List<Car> findByBodyTypeAndCarYearGreaterThanEqualAndPriceLessThanEqual(Bodytype bodytype, Integer carYear, Double price);
    List<Car> findByCarYearGreaterThanEqualAndPriceLessThanEqual(Integer carYear, Double price);


















    List<Car> getAllCarsAndByBodyType(Bodytype bodyType);




}
