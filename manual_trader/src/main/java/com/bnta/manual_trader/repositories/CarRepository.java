package com.bnta.manual_trader.repositories;

import com.bnta.manual_trader.models.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {

}
