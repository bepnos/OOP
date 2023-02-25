package mymath;

import java.util.Arrays;

public class test {
	
	public static void main(String[] args) {
		int xs[] = {10, 20, 30, 40};
		int result[] = MyMath.insert(xs, 3, 15);
		System.out.println(Arrays.toString(result));
		int xs2[] = {10, 20, 30, 40};
		int result2[] = MyMath.insert(xs2, 3, 60);
		System.out.println(Arrays.toString(result2));
	}
}
