package com.bnta.manual_trader.components;

import com.bnta.manual_trader.models.*;
import com.bnta.manual_trader.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
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
    CustomerRepository customerRepository;

    @Autowired
    PurchaseRepository purchaseRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        Dealership dealership1 = new Dealership("Sam's Dealership", "London");
        Dealership dealership2 = new Dealership("John's Dealership", "Glasgow");
        Dealership dealership3 = new Dealership("Simon's Dealership", "Birmingham");
        Dealership dealership4 = new Dealership("Michael's Dealership", "Manchester");
        Dealership dealership5 = new Dealership("Amy's Dealership", "Nottingham");
        dealershipRepository.saveAll(Arrays.asList(dealership1, dealership2, dealership3, dealership4, dealership5));

        Dealer dealer1 = new Dealer("Frank", dealership1);
        Dealer dealer2 = new Dealer("Steven", dealership2);
        Dealer dealer3 = new Dealer("Usman", dealership2);
        Dealer dealer4 = new Dealer("Mary", dealership3);
        Dealer dealer5 = new Dealer("Jessica", dealership3);
        Dealer dealer6 = new Dealer("Susan", dealership4);
        Dealer dealer7 = new Dealer("Charles", dealership5);
        Dealer dealer8 = new Dealer("Karen", dealership5);
        dealerRepository.saveAll(Arrays.asList(dealer1, dealer2, dealer3, dealer4, dealer5, dealer6, dealer7, dealer8));

        Car car1 = new Car(Bodytype.COUPE, "BMW", "Red", 2020, 35999.99, dealership1);
        Car car2 = new Car(Bodytype.HATCHBACK,  "Audi", "Grey", 2016 , 30000, dealership1);
        Car car3 = new Car(Bodytype.SUV, "Range Rover", "Black", 2017, 45000, dealership2);
        Car car4 = new Car(Bodytype.SALOON, "Volvo", "Red", 2015, 23000, dealership2);
        Car car5 = new Car(Bodytype.COUPE, "Audi", "Black", 2018, 40000, dealership2);
        Car car6 = new Car(Bodytype.ESTATE, "Ford", "White", 2021, 27000, dealership3);
        Car car7 = new Car(Bodytype.SUV, "Mercedes-Benz", "Grey", 2017, 30000, dealership3);
        Car car8 = new Car(Bodytype.HATCHBACK, "Vauxhall", "White", 2015, 6000, dealership3);
        Car car9 = new Car(Bodytype.SALOON, "Volkswagen", "Blue", 2018, 16000, dealership4);
        Car car10 = new Car(Bodytype.CONVERTIBLE, "Mercedes-Benz", "Grey", 2018, 25000, dealership4);
        Car car11 = new Car(Bodytype.HATCHBACK, "Ford", "Black", 2014, 7000, dealership4);
        Car car12 = new Car(Bodytype.COUPE, "Volvo", "White", 2013, 6000, dealership5);
        Car car13 = new Car(Bodytype.ESTATE, "Audi", "Black", 2020, 20200, dealership5);
        Car car14 = new Car(Bodytype.ESTATE, "Volkswagen", "Black", 2016, 13200, dealership4);
        Car car15 = new Car(Bodytype.ESTATE, "Mercedes-Benz", "White", 2018, 15800, dealership3);
        Car car16 = new Car(Bodytype.CONVERTIBLE, "Audi", "Black", 2015, 12600, dealership1);
        Car car17 = new Car(Bodytype.CONVERTIBLE, "Mazda", "Grey", 2011, 9495, dealership2);
        Car car18 = new Car(Bodytype.SUV, "Citroen", "White", 2018, 8800, dealership1);
        Car car19 = new Car(Bodytype.SUV, "Vauxhall", "White", 2017, 10200, dealership5);
        Car car20 = new Car(Bodytype.SUV, "Mitsubishi", "White", 2013, 6000, dealership5);
        Car car21 = new Car(Bodytype.COUPE, "Hyundai", "Grey", 2015, 7000, dealership1);
        Car car22 = new Car(Bodytype.COUPE, "Audi", "Blue", 2012, 13000, dealership2);
        Car car23 = new Car(Bodytype.SALOON, "Jaguar", "Blue", 2017, 14500, dealership3);
        Car car24 = new Car(Bodytype.HATCHBACK, "Ford", "Red", 2016, 7400, dealership4);
        Car car25 = new Car(Bodytype.SALOON, "Mazda", "Grey", 2015, 12500, dealership5);

        carRepository.saveAll(Arrays.asList(car1, car2, car3, car4, car5, car6, car7, car8, car9, car10, car11, car12,
                car13, car14, car15, car16, car17, car18, car19, car20, car21, car22, car23, car24, car25));

        Customer customer1 = new Customer("Jake", "jake123@hotmail.com");
        Customer customer2 = new Customer("Linda", "linda45@yahoo.com");
        Customer customer3 = new Customer("Scarlett", "scarlett987@gmail.com");
        Customer customer4 = new Customer("Jamie", "jamie765@gmail.com");
        Customer customer5 = new Customer("Elsie", "elsie65@yahoo.com");
        Customer customer6 = new Customer("xavier", "xavier5@hotmail.com");
        Customer customer7 = new Customer("Phil", "Phil2@gmail.com");
        Customer customer8 = new Customer("Phillipa", "Phillipa2@gmail.com");
        Customer customer9 = new Customer("Lauren", "Lauren142@yahoo.com");
        Customer customer10 = new Customer("Henry","Henry435@gmail.com");

        customerRepository.saveAll(Arrays.asList(customer1, customer2, customer3, customer4, customer5, customer6, customer7,
                customer8, customer9,customer10));

        Purchase purchase1 = new Purchase(LocalDate.of(2022,3, 4), customer2, car5);
        Purchase purchase2 = new Purchase(LocalDate.of(2021,4, 5), customer1, car7);
        Purchase purchase3 = new Purchase(LocalDate.of(2022,6, 8), customer3, car4);
        Purchase purchase4 = new Purchase(LocalDate.of(2020,9, 12), customer4, car9);
        Purchase purchase5 = new Purchase(LocalDate.of(2022,1, 13), customer4, car10);
        Purchase purchase6 = new Purchase(LocalDate.of(2022,1, 13), customer4, car11);
        Purchase purchase7 = new Purchase(LocalDate.of(2019,11, 23), customer5, car19);
        Purchase purchase8 = new Purchase(LocalDate.of(2019,12, 3), customer6, car18);
        Purchase purchase9 = new Purchase(LocalDate.of(2020,2, 5), customer7, car14);
        Purchase purchase10 = new Purchase(LocalDate.of(2018,7, 22), customer8, car13);
        purchaseRepository.saveAll(Arrays.asList(purchase1, purchase2, purchase3, purchase4, purchase5, purchase6,
                purchase7, purchase8, purchase9, purchase10));


    }
}
