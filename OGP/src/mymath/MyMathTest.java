package mymath;

// Ik snap het niet
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import junit.framework.Assert;

class MyMathTest {
	
	@Test
	void sqrtTest() {
		int a = 3;
		int b = 4;
		int c2 = a*a + b*b;
		int c = MyMath.sqrt(c2);
		assert c == 5;
		assert MyMath.sqrt(0) == 0;
	}
	
	@Test
	void binarySearchTest() {
		int[] xs = {10, 20, 30, 40};
		assertEquals(0, MyMath.binarySearch(xs, -7));
		assertEquals(1, MyMath.binarySearch(xs, 15));
		assertEquals(2, MyMath.binarySearch(xs, 30));
		assertEquals(4, MyMath.binarySearch(xs, 50));
	}
	
	@Test
	void insertionTest() {
		int xs[] = {10, 20, 30, 40};
		int expected[] = {10, 15, 20};
		assertArrayEquals(expected, MyMath.insert(xs, 3, 15));
		
		
	}

}
