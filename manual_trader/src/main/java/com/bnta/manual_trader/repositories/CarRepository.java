package com.bnta.manual_trader.repositories;

import com.bnta.manual_trader.models.Bodytype;
import com.bnta.manual_trader.models.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.StreamingHttpOutputMessage;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {

    List<Car> findByBrandIgnoreCase(String brand);
    List<Car> findByColour(String Colour);
    List<Car> findByCarYearGreaterThanEqual(Integer carYear);
    List<Car> findByPriceLessThanEqual(Double price);
    List<Car> findByBodyType(Bodytype bodytype);


    List<Car> findByBrandIgnoreCaseAndColour(String brand, String colour);
    List<Car> findByBrandIgnoreCaseAndBodyType(String brand, Bodytype bodyType);
    List<Car> findByBrandIgnoreCaseAndCarYearGreaterThanEqual(String brand, Integer carYear);
    List<Car> findByBrandIgnoreCaseAndPriceLessThanEqual(String brand, Double price);
    List<Car> findByBrandIgnoreCaseAndColourAndBodyType(String brand, String colour, Bodytype bodytype);
    List<Car> findByBrandIgnoreCaseAndColourAndPriceLessThanEqual(String brand, String colour, Double price);
    List<Car> findByBrandIgnoreCaseAndColourAndBodyTypeAndCarYearGreaterThanEqual(String brand, String colour, Bodytype bodytype, Integer carYear);
    List<Car> findByBrandIgnoreCaseAndColourAndBodyTypeAndPriceLessThanEqual(String brand, String colour, Bodytype bodytype, Double price);
    List<Car> findByBrandIgnoreCaseAndColourAndBodyTypeAndCarYearGreaterThanEqualAndPriceLessThanEqual(String brand, String colour, Bodytype bodytype, Integer carYear, Double price);
    List<Car> findByBrandIgnoreCaseAndColourAndCarYearGreaterThanEqual(String brand, String colour, Integer carYear);

    List<Car> findByBrandIgnoreCaseAndBodyTypeAndCarYearGreaterThanEqual(String brand, Bodytype bodytype, Integer carYear);
    List<Car> findByBrandIgnoreCaseAndBodyTypeAndPriceLessThanEqual(String brand, Bodytype bodytype, Double price);
    List<Car> findByBrandIgnoreCaseAndCarYearGreaterThanEqualAndPriceLessThanEqual(String brand, Integer carYear, Double price);

    List<Car> findByBrandIgnoreCaseAndColourAndCarYearGreaterThanEqualAndPriceLessThanEqual(String brand, String colour, Integer carYear, Double Price);
    List<Car> findByBrandIgnoreCaseAndBodyTypeAndCarYearGreaterThanEqualAndPriceLessThanEqual(String Brand, Bodytype bodytype, Integer carYear, Double Price);


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
}
