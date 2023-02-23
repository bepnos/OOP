package mymath;

import java.util.Arrays;
import java.util.stream.Stream;

public class test {
	
	public static void main(String[] args) {
	int[] xs = {10, 20, 30, 40};
	int[] result = MyMath.insert(xs, 4, 15);
	System.out.println(Arrays.toString(result));
	
	}
}
