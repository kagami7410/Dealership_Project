package com.bnta.manual_trader.repositories;

import com.bnta.manual_trader.models.Bodytype;
import com.bnta.manual_trader.models.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.StreamingHttpOutputMessage;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {

    List<Car> findByBrandIgnoreCase(String brand);
    List<Car> findByColourIgnoreCase(String ColourIgnoreCase);
    List<Car> findByCarYearGreaterThanEqual(Integer carYear);
    List<Car> findByPriceLessThanEqual(Double price);
    List<Car> findByBodyType(Bodytype bodytype);

    List<Car> findByBrandIgnoreCaseAndColourIgnoreCase(String brand, String colour);
    List<Car> findByBrandIgnoreCaseAndBodyType(String brand, Bodytype bodyType);
    List<Car> findByBrandIgnoreCaseAndCarYearGreaterThanEqual(String brand, Integer carYear);
    List<Car> findByBrandIgnoreCaseAndPriceLessThanEqual(String brand, Double price);
    List<Car> findByBrandIgnoreCaseAndColourIgnoreCaseAndBodyType(String brand, String colour, Bodytype bodytype);
    List<Car> findByBrandIgnoreCaseAndColourIgnoreCaseAndPriceLessThanEqual(String brand, String colour, Double price);
    List<Car> findByBrandIgnoreCaseAndColourIgnoreCaseAndBodyTypeAndCarYearGreaterThanEqual(String brand, String colour, Bodytype bodytype, Integer carYear);
    List<Car> findByBrandIgnoreCaseAndColourIgnoreCaseAndBodyTypeAndPriceLessThanEqual(String brand, String colour, Bodytype bodytype, Double price);
    List<Car> findByBrandIgnoreCaseAndColourIgnoreCaseAndBodyTypeAndCarYearGreaterThanEqualAndPriceLessThanEqual(String brand, String colour, Bodytype bodytype, Integer carYear, Double price);
    List<Car> findByBrandIgnoreCaseAndColourIgnoreCaseAndCarYearGreaterThanEqual(String brand, String colour, Integer carYear);

    List<Car> findByBrandIgnoreCaseAndBodyTypeAndCarYearGreaterThanEqual(String brand, Bodytype bodytype, Integer carYear);
    List<Car> findByBrandIgnoreCaseAndBodyTypeAndPriceLessThanEqual(String brand, Bodytype bodytype, Double price);
    List<Car> findByBrandIgnoreCaseAndCarYearGreaterThanEqualAndPriceLessThanEqual(String brand, Integer carYear, Double price);
    List<Car> findByBrandIgnoreCaseAndColourIgnoreCaseAndCarYearGreaterThanEqualAndPriceLessThanEqual(String brand, String colour, Integer carYear, Double Price);
    List<Car> findByBrandIgnoreCaseAndBodyTypeAndCarYearGreaterThanEqualAndPriceLessThanEqual(String Brand, Bodytype bodytype, Integer carYear, Double Price);

    List<Car> findByColourIgnoreCaseAndBodyType(String colour, Bodytype bodytype);
    List<Car> findByColourIgnoreCaseAndCarYearGreaterThanEqual(String colour, Integer carYear);
    List<Car> findByColourIgnoreCaseAndPriceLessThanEqual(String colour, Double price);
    List<Car> findByColourIgnoreCaseAndBodyTypeAndCarYearGreaterThanEqual(String colour, Bodytype bodytype, Integer carYear);
    List<Car> findByColourIgnoreCaseAndBodyTypeAndPriceLessThanEqual(String colour, Bodytype bodytype, Double price);
    List<Car> findByColourIgnoreCaseAndBodyTypeAndCarYearGreaterThanEqualAndPriceLessThanEqual(String colour, Bodytype bodytype, Integer carYear, Double price);
    List<Car> findByColourIgnoreCaseAndCarYearGreaterThanEqualAndPriceLessThanEqual(String colour, Integer carYear, Double price);

    List<Car> findByBodyTypeAndCarYearGreaterThanEqual(Bodytype bodytype, Integer carYear);
    List<Car> findByBodyTypeAndPriceLessThanEqual(Bodytype bodyType, Double price);
    List<Car> findByBodyTypeAndCarYearGreaterThanEqualAndPriceLessThanEqual(Bodytype bodytype, Integer carYear, Double price);
    List<Car> findByCarYearGreaterThanEqualAndPriceLessThanEqual(Integer carYear, Double price);
}
