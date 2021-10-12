package racinggame.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racinggame.domains.Cars;
import racinggame.exceptions.InvalidCsvException;

import static org.junit.jupiter.api.Assertions.*;

class CarFactoryTest {
	@DisplayName("csv 문자열을 이용하여 N대의 자동차를 생서할 수 있다.")
	@Test
	public void generateCarByCsvTest() {
		String carName1 = "car1";
		String carName2 = "car2";
		String carName3 = "car3";
		String csvCarName = carName1 + "," + carName2 + ",";

		Cars cars = CarFactory.generateCarsBy(csvCarName);

		assertEquals(cars.getCarList().get(0).getName(), carName1);
		assertEquals(cars.getCarList().get(1).getName(), carName2);
		assertEquals(cars.getCarList().get(2).getName(), carName3);
	}

	@DisplayName("유효하지 않은 csv는 InvalidCsvException 발생")
	@Test
	public void invalidCsvException() {
		String invalidCsv = "car1,car2,";
		
		assertThrows(InvalidCsvException.class, () -> CarFactory.generateCarsBy(invalidCsv));
	}
}
