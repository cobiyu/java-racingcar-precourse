package racinggame;

import nextstep.utils.Console;
import racinggame.domains.Car;
import racinggame.domains.Cars;
import racinggame.domains.MovingType;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cobiyu
 */
public class ConsoleView {
	public static final String PROGRESS_BAR = "-";

	/**
	 * 자동차 이름 입력
	 */
	public static String inputCarsName() {
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

		return Console.readLine();
	}

	/**
	 * 시도할 회수 입력
	 */
	public static int inputTryCount() {
		System.out.println("시도할 회수는 몇회인가요?");
		String str = Console.readLine();

		return Integer.parseInt(str);
	}

	/**
	 * 레이싱 과정 출력
	 */
	public static void printProgressBy(Cars cars) {
		System.out.println("실행 결과");
		List<Car> carList = cars.getCarList();

		for (int i = 0; i < cars.getMoveCount(); i++) {
			printProgressBarBy(carList, i);
			System.out.println();
		}
	}

	/**
	 * 자동차 N대의 M번째 까지 주행 progress bar 출력
	 *
	 * @param carList 자동차 목록
	 * @param moveCount 자동차 이동 카운트
	 */
	public static void printProgressBarBy(List<Car> carList, int moveCount) {
		for (Car car : carList) {
			System.out.print(car.getName() + " : ");
			System.out.println(getProgressBarByCarAndMoveCount(car, moveCount));
		}
	}

	/**
	 * 자동차 1대의 N번째 까지 주행 progress bar 추출
	 *
	 * @param car 자동차
	 * @param moveCount 자동차 이동 카운트
	 * @return 주행 과정
	 */
	public static String getProgressBarByCarAndMoveCount(Car car, int moveCount) {
		StringBuilder progressBar = new StringBuilder();
		for (int i = 0; i < moveCount + 1; i++) {
			progressBar.append(getProgressBarByMovingType(car.getMovingTypeList().get(i)));
		}

		return progressBar.toString();
	}

	/**
	 * MovingType별 progress bar 추출
	 */
	public static String getProgressBarByMovingType(MovingType movingType) {
		StringBuilder progressBar = new StringBuilder();
		for (int i = 0; i < movingType.getWeighting(); i++) {
			progressBar.append(PROGRESS_BAR);
		}

		return progressBar.toString();
	}

	/**
	 * 우승자 출력
	 * @param cars 우승자를 판별할 Cars
	 */
	public static void printWinners(Cars cars) {
		List<Car> winnerCars = cars.getWinnerCars();
		List<String> winnersNameList = new ArrayList<>();
		for (Car winnerCar : winnerCars) {
			winnersNameList.add(winnerCar.getName());
		}

		String winnersName = String.join(", ", winnersNameList);

		System.out.println("최종 우승자는 " + winnersName + " 입니다.");
	}
}