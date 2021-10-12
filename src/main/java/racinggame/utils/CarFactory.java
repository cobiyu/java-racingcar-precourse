package racinggame.utils;

import racinggame.domains.Car;
import racinggame.domains.Cars;
import racinggame.exceptions.InvalidCsvException;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cobiyu
 */
public class CarFactory {
	/**
	 * csv 기반 Car, Cars 생성
	 *
	 * @param csv 자동차 이름 csv
	 * @return Cars
	 */
	public static Cars generateCarsBy(String csv) {
		validationCsvCheck(csv);
		String[] csvSplit = csv.split(",");

		List<Car> carList = new ArrayList<>();
		for (String carName : csvSplit) {
			carList.add(new Car(carName));
		}

		return new Cars(carList);
	}

	/**
	 * 유효한 csv 체크
	 */
	private static void validationCsvCheck(String csv) {
		String[] csvSplit = csv.split(",");
		int commaCount = findCharacterCountInString(csv, ',');

		if (csvSplit.length != (commaCount + 1)) {
			throw new InvalidCsvException(csv);
		}
	}

	/**
	 * 문자열에서 특정 문자의 카운트
	 *
	 * @param str 검사할 문자열
	 * @param findTarget 문자열에서 찾을 문자
	 * @return 특정 문자의 카운트
	 */
	private static int findCharacterCountInString(String str, char findTarget) {
		int count = 0;

		for (int i = 0; i < str.length(); i++) {
			count += (str.charAt(i) == findTarget) ? 1 : 0;
		}

		return count;
	}
}
