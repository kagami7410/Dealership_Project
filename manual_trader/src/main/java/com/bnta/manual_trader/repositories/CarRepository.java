package com.bnta.manual_trader.repositories;

import com.bnta.manual_trader.models.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {

    List<Car> findByBrand(String brand);
    List<Car> findByColour(String Colour);
    List<Car> findByYear(int year);

}
