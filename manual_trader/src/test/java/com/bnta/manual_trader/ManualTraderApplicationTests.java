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
	public void canFindCarByAttribute(){
		List<Car> carFoundByBrand = carRepository.findByBrand("BMW");
		assertThat(carFoundByBrand.size()).isEqualTo(1);

		List<Car> carFoundByBodyType = carRepository.findByBodyType(Bodytype.CONVERTIBLE);
		assertThat(carFoundByBodyType.size()).isEqualTo(3);

		List<Car> carFoundByPriceGreaterThan = carRepository.findByPriceGreaterThan(10000.00);
		assertThat(carFoundByPriceGreaterThan.size()).isEqualTo(17);

		List<Car> carFoundByCarYear = carRepository.findByCarYearGreaterThan(2020);
		assertThat(carFoundByCarYear.size()).isEqualTo(2);

		List<Car> carFoundByColour = carRepository.findByColour("Red");
		assertThat(carFoundByColour.size()).isEqualTo(3);
	}


}
