package com.bnta.manual_trader;

import com.bnta.manual_trader.models.Bodytype;
import com.bnta.manual_trader.models.Car;
import com.bnta.manual_trader.repositories.CarRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@SpringBootTest
class ManualTraderApplicationTests {

    @Autowired
    CarRepository carRepository;

    @Test
    void contextLoads() {
    }

    @Test
    public void canFindCarByBrand() {
        List<Car> carFoundByBrand = carRepository.findByBrand("BMW");
        assertThat(carFoundByBrand.size()).isEqualTo(1);
    }

    @Test
    public void canFindCarByBodyType() {
        List<Car> carFoundByBodyType = carRepository.findByBodyType(Bodytype.CONVERTIBLE);
        assertThat(carFoundByBodyType.size()).isEqualTo(3);
    }

    @Test
    public void canFindCarByPriceGreaterThan() {
        List<Car> carFoundByPriceGreaterThan = carRepository.findByPriceGreaterThanEqual(10000.00);
        assertThat(carFoundByPriceGreaterThan.size()).isEqualTo(17);
    }

    @Test
    public void canFindCarByCarYearGreaterThan() {
        List<Car> carFoundByCarYear = carRepository.findByCarYearGreaterThanEqual(2020);
        assertThat(carFoundByCarYear.size()).isEqualTo(3);
    }

    @Test
    public void canFindCarByColour() {
        List<Car> carFoundByColour = carRepository.findByColour("Red");
        assertThat(carFoundByColour.size()).isEqualTo(3);
    }


}
