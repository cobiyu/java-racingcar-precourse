package racinggame.domains;

/**
 * @author cobiyu
 */
public enum MovingType {
	GO(1),
	STOP(0);

	/**
	 * 레이싱에 사용되는 기준값
	 */
	public static final int MOVING_TYPE_VALUE = 4;
	/**
	 * Type별 가중치
	 */
	private final int weighting;

	/**
	 * constructor
	 */
	MovingType(int weighting) {
		this.weighting = weighting;
	}

	/**
	 * weighting getter
	 */
	public int getWeighting() {
		return weighting;
	}

	/**
	 * 숫자에 맞는 MovingType 생성
	 *
	 * @param racingNumber MovingType 생성에 판단할 숫자
	 * @return GO or STOP
	 */
	public static MovingType of(int racingNumber) {
		if (racingNumber >= MOVING_TYPE_VALUE) {
			return GO;
		}
		return STOP;
	}
}
