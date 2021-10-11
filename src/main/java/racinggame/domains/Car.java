package racinggame.domains;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cobiyu
 */
public class Car {
	private static final int MAX_NAME_LENGTH = 5;
	private final String name;
	private final List<MovingType> movingTypeList;

	public Car(String name) {
		this.name = name;
		this.movingTypeList = new ArrayList<>();
	}

	public void moving(MovingType movingType) {
		
	}

	public int getMovingDistance() {
		return 0;
	}

	public String getName() {
		return null;
	}

	public List<MovingType> getMovingTypeList() {
		return null;
	}
}
