package com.bnta.manual_trader.components;

import com.bnta.manual_trader.models.Car;
import com.bnta.manual_trader.models.Dealer;
import com.bnta.manual_trader.models.Dealership;
import com.bnta.manual_trader.models.User;
import com.bnta.manual_trader.repositories.CarRepository;
import com.bnta.manual_trader.repositories.DealerRepository;
import com.bnta.manual_trader.repositories.DealershipRepository;
import com.bnta.manual_trader.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    CarRepository carRepository;

    @Autowired
    DealershipRepository dealershipRepository;

    @Autowired
    DealerRepository dealerRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        Dealership dealership1 = new Dealership("Sam's Dealership", "London");
        Dealership dealership2 = new Dealership("John's Dealership", "Glasgow");
        Dealership dealership3 = new Dealership("Simon's Dealership", "Birmingham");
        Dealership dealership4 = new Dealership("Michael's Dealership", "Manchester");
        Dealership dealership5 = new Dealership("Amy's Dealership", "Nottingham");
        dealershipRepository.saveAll(Arrays.asList(dealership1, dealership2, dealership3, dealership4, dealership5));

        Dealer dealer1 = new Dealer(1, dealership1);
        Dealer dealer2 = new Dealer(1, dealership2);
        Dealer dealer3 = new Dealer(1, dealership2);
        Dealer dealer4 = new Dealer(1, dealership3);
        Dealer dealer5 = new Dealer(1, dealership3);
        Dealer dealer6 = new Dealer(1, dealership4);
        Dealer dealer7 = new Dealer(1, dealership5);
        Dealer dealer8 = new Dealer(1, dealership5);
        dealerRepository.saveAll(Arrays.asList(dealer1, dealer2, dealer3, dealer4, dealer5, dealer6, dealer7, dealer8));

        Car car1 = new Car("Coupe", "BMW", "Red", 2020, 35999.99, dealership1);
        Car car2 = new Car("Hatchback", "Audi", "Grey", 2016 , 30000, dealership1);
        Car car3 = new Car("SUV", "Range Rover", "Black", 2017, 45000, dealership2);
        Car car4 = new Car("Saloon", "Volvo", "Red", 2015, 23000, dealership2);
        Car car5 = new Car("Coupe", "Audi", "Black", 2018, 40000, dealership2);
        Car car6 = new Car("Estate", "Ford", "White", 2021, 27000, dealership3);
        Car car7 = new Car("SUV", "Mercedes-Benz", "Grey", 2017, 30000, dealership3);
        Car car8 = new Car("Hatchback", "Vauxhall", "White", 2015, 6000, dealership3);
        Car car9 = new Car("Saloon", "Volkswagen", "Blue", 2018, 16000, dealership4);
        Car car10 = new Car("Convertible", "Mercedes-Benz", "Grey", 2018, 25000, dealership4);
        Car car11 = new Car("Hatchback", "Ford", "Black", 2014, 7000, dealership4);
        Car car12 = new Car("Coupe", "Volvo", "White", 2013, 6000, dealership5);
        carRepository.saveAll(Arrays.asList(car1, car2, car3, car4, car5, car6, car7, car8, car9, car10, car11, car12));

        User user1 = new User("Anna", "anna@gmail.com");
        User user2 = new User("Larry", "laryybird8374@gmail.com");
        User user3 = new User("Kendall", "Kendi@gmail.com");
        User user4 = new User("Hannah","Hannah1928@yahoo.com");
        User user5 = new User("Hailey", "hailey74@outlook.com");
        User user6 = new User("Andy", "Andy3834@hotmail.com");
        User user7 = new User("Michael","Michael587@gmail.com");
        userRepository.saveAll(Arrays.asList(user1, user2, user3, user4, user5, user6, user7));
    }
}
