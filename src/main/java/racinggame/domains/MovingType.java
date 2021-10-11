package racinggame.domains;

/**
 * @author cobiyu
 */
public enum MovingType {
	GO,
	STOP;

	public static MovingType of(int racingNumber) {
		return GO;
	}
}
