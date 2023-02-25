package intervallen;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class IntervallenTest {
	
	@Test
	void test() {
		Interval meting1 = new Interval(45, 50);
		Interval meting2 = new Interval(30, 33);
		
		Interval totaleLengte = meting1.telOp(meting2);
		
		assertEquals(75, totaleLengte.getOndergrens());
		assertEquals(83, totaleLengte.getBovengrens());
		
		totaleLengte.setLengte(10);
		assertEquals(75, totaleLengte.getOndergrens());
		assertEquals(85, totaleLengte.getBovengrens());
	}

}