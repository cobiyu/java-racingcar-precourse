package racinggame.domains;

import nextstep.utils.Randoms;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cobiyu
 */
public class Cars {
	private static final int MIN_RACING_NUMBER = 0;
	private static final int MAX_RACING_NUMBER = 9;
	private final List<Car> carList;

	/**
	 * constructor
	 */
	public Cars(List<Car> carList) {
		this.carList = carList;
	}

	/**
	 * 차량별로 추출한 0~9 random 숫자에 맞게 차량 이동  
	 */
	public void movingByRandomNumber() {
		for (Car car : carList) {
			int randomNumber = Randoms.pickNumberInRange(MIN_RACING_NUMBER, MAX_RACING_NUMBER);
			MovingType movingType = MovingType.of(randomNumber);
			car.moving(movingType);
		}
	}

	/**
	 * 우승 자동차 추출
	 */
	public List<Car> getWinnerCars() {
		List<Car> winnerCarList = new ArrayList<>();

		for (Car car : carList) {
			addWinnerCarsIfMaxDistance(winnerCarList, car);
		}

		return winnerCarList;
	}

	/**
	 * carList getter
	 */
	public List<Car> getCarList() {
		return carList;
	}

	/**
	 * 자동차 중 최대 이동 자동차의 거리 추출
	 */
	private int getMaxDistance() {
		int maxDistance = 0;

		for (Car car : carList) {
			maxDistance = Math.max(maxDistance, car.getMovingDistance());
		}

		return maxDistance;
	}

	/**
	 * 우승 자동차 목록 추가
	 *
	 * @param winnerCarList 우승 자동차 목록
	 * @param car 우승인지 판별한 자동차
	 */
	private void addWinnerCarsIfMaxDistance(List<Car> winnerCarList, Car car) {
		int maxDistance = getMaxDistance();

		if (car.getMovingDistance() == maxDistance) {
			winnerCarList.add(car);
		}
	}
}
