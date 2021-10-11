package racinggame.domains;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racinggame.exceptions.InvalidCarNameException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author cobiyu
 */
class CarTest {
	@DisplayName("자동차 생성 테스트")
	@Test
	public void createCarTest(){
		String carName = "car1";
		Car car = new Car(carName);

		assertEquals(car.getName(), carName);
		assertEquals(car.getMovingTypeList().size(), 0);
		assertEquals(car.getMovingDistance(), 0);
	}
	
	@DisplayName("5자 이상의 자동차이름은 InvalidCarNameException 발생")
	@Test
	public void invalidCarNameTest(){
		String carName = "testCarName";

		assertThrows(
				InvalidCarNameException.class,
				() -> new Car(carName)
		);
	}

	@DisplayName("자동차 이동 테스트")
	@Test
	public void moveCarTest(){
		// given
		String carName = "car1";
		Car car = new Car(carName);

		// when
		car.moving(MovingType.GO);
		car.moving(MovingType.STOP);
		car.moving(MovingType.GO);
		
		//then
		assertEquals(car.getMovingDistance(), 2);
		assertEquals(car.getMovingTypeList().get(0), MovingType.GO);
		assertEquals(car.getMovingTypeList().get(1), MovingType.STOP);
		assertEquals(car.getMovingTypeList().get(2), MovingType.GO);
	}
}
