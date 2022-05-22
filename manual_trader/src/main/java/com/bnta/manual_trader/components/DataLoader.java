package com.bnta.manual_trader.components;

import com.bnta.manual_trader.models.Car;
import com.bnta.manual_trader.models.Dealer;
import com.bnta.manual_trader.models.Dealership;
import com.bnta.manual_trader.repositories.CarRepository;
import com.bnta.manual_trader.repositories.DealerRepository;
import com.bnta.manual_trader.repositories.DealershipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    CarRepository carRepository;

    @Autowired
    DealershipRepository dealershipRepository;

    @Autowired
    DealerRepository dealerRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        Dealership dealership1 = new Dealership("BMW Dealership", "London");
        dealershipRepository.save(dealership1);

        Dealer dealer1 = new Dealer(1, dealership1);
        dealerRepository.save(dealer1);

        Car car1 = new Car("Coupe", "BMW", "Red", 2020, 35999.99, dealership1);
        carRepository.save(car1);

    }
}
