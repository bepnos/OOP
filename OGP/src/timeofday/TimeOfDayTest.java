package timeofday;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TimeOfDayTest {

	@Test
	void test() {
		TimeOfDay tijd1 = new TimeOfDay(10, 30);
		TimeOfDay tijd2 = new TimeOfDay(22, 40); 
		
		assert tijd1.getHours() == 10;
		assert tijd2.getMinutes() == 40;
		
		tijd1.setHours(15);
		tijd1.setMinutes(0);
		
		assert tijd1.getHours() == 15;
		assert tijd1.getMinutes() == 0;
  	}

}
