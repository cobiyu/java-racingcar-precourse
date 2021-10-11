package racinggame.domains;

import racinggame.exceptions.InvalidCarNameException;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cobiyu
 */
public class Car {
	/**
	 * 자동차 이름 길이 제한
	 */
	private static final int MAX_NAME_LENGTH = 5;
	/**
	 * 자동차 이름
	 */
	private final String name;
	/**
	 * 자동차 이동 이력
	 */
	private final List<MovingType> movingTypeList;

	/**
	 * constructor
	 * @param name 자동차 이름
	 */
	public Car(String name) {
		checkValidation(name);

		this.name = name;
		this.movingTypeList = new ArrayList<>();
	}

	/**
	 * 자동차 생성 validation
	 * @param name 자동차 이름
	 */
	private void checkValidation(String name){
		if(name.length() >= MAX_NAME_LENGTH){
			throw new InvalidCarNameException(name);
		}
	}

	/**
	 * 자동차 이동
	 * @param movingType 이동 타입
	 */
	public void moving(MovingType movingType) {
		movingTypeList.add(movingType);
	}

	/**
	 * 자동차 총 이동 거리
	 * @return 이동 거리
	 */
	public int getMovingDistance() {
		int distance = 0;

		for (int i = 0; i < movingTypeList.size(); i++) {
			distance += movingTypeList.get(i).getWeighting();
		}

		return distance;
	}

	/**
	 * name getter
	 */
	public String getName() {
		return name;
	}

	/**
	 * movingTypeList getter
	 */
	public List<MovingType> getMovingTypeList() {
		return movingTypeList;
	}
}
