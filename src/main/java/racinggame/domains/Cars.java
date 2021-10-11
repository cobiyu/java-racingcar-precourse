package racinggame.domains;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cobiyu
 */
public class Cars {
	private final List<Car> carList;

	public Cars(List<Car> carList) {
		this.carList = carList;
	}

	public void movingByRandomNumber() {
		
	}

	public List<Car> getWinnerCars() {
		List<Car> carList = new ArrayList<>();

		return carList;
	}

	/**
	 * carList getter
	 */
	public List<Car> getCarList() {
		return carList;
	}
}
