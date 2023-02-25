package strings;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StringTest {

	@Test
	void test() {
		char[] hello = {'H', 'e', 'l', 'l', 'o'};
		String myString = new String(hello);
		assertArrayEquals(
			new char[] {'H', 'e', 'l', 'l', 'o'},
			myString.toCharArray()
		);
		assertEquals(5, myString.length());
		assertEquals('H', myString.charAt(0));
		
		char[] cs = myString.toCharArray();
		cs[0] = 'B';
		assertEquals('H', myString.charAt(0));
		
		hello[0] = 'B';
		assertEquals('H', myString.charAt(0));
	}

}