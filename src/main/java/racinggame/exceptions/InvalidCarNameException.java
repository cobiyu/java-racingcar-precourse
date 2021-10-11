package racinggame.exceptions;

/**
 * @author cobiyu
 */
public class InvalidCarNameException extends RuntimeException {
	private final String carName;

	/**
	 * constructor
	 *
	 * @param carName 유효하지 않은 자동차 이름
	 */
	public InvalidCarNameException(String carName) {
		this.carName = carName;
	}

	@Override
	public String getMessage() {
		return carName + "은 자동차 이름으로 적합하지 않습니다.";
	}
}
