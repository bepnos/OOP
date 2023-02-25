package intlist;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class IntListTest {

	@Test
	void test() {
		int[] getallen = {1, 5, 6, 10};
		IntList lijst = new IntList(getallen);
		assertArrayEquals(
				new int[] {1, 5, 6, 10},
				lijst.toArray()
			);
		assertEquals(4, lijst.length());
		
		lijst = lijst.addNumber(20);
		assertArrayEquals(
				new int[] {1, 5, 6, 10, 20},
				lijst.toArray()
			);
	}

}
