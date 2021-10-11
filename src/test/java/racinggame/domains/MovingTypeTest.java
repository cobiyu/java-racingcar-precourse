package racinggame.domains;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MovingTypeTest {
	@DisplayName("4이상 숫자의 MovingType은 GO이다.")
	@Test
	public void GoTest(){
		MovingType movingType5 = MovingType.of(5);
		MovingType movingType8 = MovingType.of(8);
		
		assertEquals(movingType5, MovingType.GO);
		assertEquals(movingType8, MovingType.GO);
	}
}
