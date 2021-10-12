package racinggame.exceptions;

/**
 * @author cobiyu
 */
public class InvalidCsvException extends RuntimeException {
	private final String csv;

	/**
	 * constructor
	 * @param csv 유효하지 않은 cscv
	 */
	public InvalidCsvException(String csv) {
		this.csv = csv;
	}

	@Override
	public String getMessage() {
		return csv + "는 유효하지 않은 csv입니다.";
	}
}
