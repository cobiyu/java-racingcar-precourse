package racinggame.domains;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author cobiyu
 */
class CarsTest {

	@DisplayName("자동차 N대 생성 테스트")
	@Test
	public void createCarsTest() {
		// given
		Car car1 = new Car("car1");
		Car car2 = new Car("car2");
		Car car3 = new Car("car3");

		// when
		Cars cars = new Cars(Arrays.asList(car1, car2, car3));

		// then
		assertEquals(cars.getCarList().size(), 3);
	}

	@DisplayName("우승 자동차 1대 테스트")
	@Test
	public void oneWinnerCarsTest() {
		// given
		Car car1 = new Car("car1");
		Car car2 = new Car("car2");
		Car car3 = new Car("car3");

		car1.moving(MovingType.GO);
		car1.moving(MovingType.GO);
		car1.moving(MovingType.GO);
		car3.moving(MovingType.GO);

		// when
		Cars cars = new Cars(Arrays.asList(car1, car2, car3));
		List<Car> winnerCars = cars.getWinnerCars();

		// then
		assertEquals(winnerCars.size(), 1);
		assertTrue(winnerCars.contains(car1));
	}

	@DisplayName("우승 자동차 N대 테스트")
	@Test
	public void multipleWinnerCarsTest() {
		// given
		Car car1 = new Car("car1");
		Car car2 = new Car("car2");
		Car car3 = new Car("car3");

		car1.moving(MovingType.GO);
		car1.moving(MovingType.GO);
		car2.moving(MovingType.GO);
		car2.moving(MovingType.GO);
		car3.moving(MovingType.GO);

		// when
		Cars cars = new Cars(Arrays.asList(car1, car2, car3));
		List<Car> winnerCars = cars.getWinnerCars();

		// then
		assertEquals(winnerCars.size(), 2);
		assertTrue(winnerCars.contains(car1));
		assertTrue(winnerCars.contains(car2));
	}

}
