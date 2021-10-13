package racinggame;

import racinggame.domains.Cars;
import racinggame.exceptions.ExceptionHandler;
import racinggame.utils.CarFactory;

/**
 * @author cobiyu
 */
public class RacingController {
	/**
	 * 레이싱 시작
	 */
	public void startRacing() {
		Cars cars = generateCars();
		int tryCount = inputTryCount();

		movingCarsByTryCount(cars, tryCount);

		printResult(cars);
	}

	/**
	 * 자동차 생성
	 */
	private Cars generateCars() {
		String carsName = ConsoleView.inputCarsName();
		try {
			return CarFactory.generateCarsBy(carsName);
		} catch (Exception ex) {
			ExceptionHandler.handling(ex);
			return generateCars();
		}
	}

	/**
	 * 레이싱 회수 입력
	 */
	private int inputTryCount() {
		try {
			return ConsoleView.inputTryCount();
		} catch (Exception ex){
			ExceptionHandler.handling(ex);
			return inputTryCount();
		}
	}

	/**
	 * 자동차 이동
	 */
	private void movingCarsByTryCount(Cars cars, int tryCount) {
		for (int i = 0; i < tryCount; i++) {
			cars.movingByRandomNumber();
		}
	}

	/**
	 * 레이싱 결과 출력
	 */
	private void printResult(Cars cars){
		ConsoleView.printProgressBy(cars);
		ConsoleView.printWinners(cars);
	}
}