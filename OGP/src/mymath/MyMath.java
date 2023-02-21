package mymath;

import java.util.Arrays;
import java.util.stream.IntStream;

public class MyMath {

	/**
	 * Returns the square root (rounded down) of the given nonnegative number.
	 * 
	 * @pre The given number is nonnegative.
	 *     | 0 <= x
	 * @post The result is the greatest nonnegative number whose square is not greater
	 *       than the given number.
	 *     | 0 <= result && result * result <= x && x < (result + 1) * (result + 1)
	 */
	static int sqrt(int x) {
		int r = 0;
		while ((r + 1) * (r + 1) <= x)
			r++;
		return r;
	}
	
	/**
	 * Returns the index where the given value belongs in the given sorted array. If the given value
	 * appears in the given array, returns the index of the first occurrence.
	 * 
	 * @pre `haystack` is not null.
	 *     | haystack != null
	 * @pre `haystack` is sorted.
	 *     | IntStream.range(1, haystack.length).allMatch(i -> haystack[i - 1] <= haystack[i])
	 * @post The result is nonnegative
	 *     | 0 <= result
	 * @post The result is not greater than the length of `haystack`
	 *     | result <= haystack.length
	 * @post At each index less than `result`, the value is less than `needle`
	 *     | IntStream.range(0, result).allMatch(i -> haystack[i] < needle)
	 * @post At each index not less than `result`, the value is not less than `needle`
	 *     | IntStream.range(result, haystack.length).allMatch(i -> needle <= haystack[i])
	 */
	static int binarySearch(int[] haystack, int needle) {
		int lo = 0;
		int hi = haystack.length;
		while (lo < hi) {
			int middle = lo + (hi - lo) / 2;
			if (needle <= haystack[middle])
				hi = middle;
			else
				lo = middle + 1;
		}
		return lo;
	}
	
	/**
	 * Returns the number of times value `v` appears at indices 0 (inclusive) through `n` (exclusive) of
	 * array `xs`.
	 * 
	 * @pre | xs != null
	 * @pre | 0 <= n && n <= xs.length
	 * @post | result == IntStream.range(0, n).filter(i -> xs[i] == v).count()
	 */
	static long count(int[] xs, int n, int v) {
		return IntStream.range(0, n).filter(i -> xs[i] == v).count();
	}
	
	/**
	 * Inserts the given value `v` into the sorted sequence of values at indices 0 (inclusive)
	 * through `n` (exclusive) in array `xs`, shifting elements to the right as necessary.
	 * 
	 * @pre | xs != null
	 * @pre | 0 <= n
	 * @pre | n < xs.length
	 * @pre The elements at indices 0 (inclusive) through `n` (exclusive) in `xs` are sorted.
	 *      | IntStream.range(1, n).allMatch(i -> xs[i - 1] <= xs[i])
	 * @post The elements at indices 0 (inclusive) through `n + 1` (exclusive) in `xs` are sorted.
	 *      | IntStream.range(1, n + 1).allMatch(i -> xs[i - 1] <= xs[i])
	 * @post For each element `e` in `xs[0:n + 1]`, the number of occurrences of `e` equals the old
	 *       number of occurrences of `e` in `xs[0:n]`, except if `e == v`.
	 *      | IntStream.range(0, n + 1).allMatch(i ->
	 *      |     count(xs, n + 1, xs[i]) ==
	 *      |     count(old(xs.clone()), n, xs[i]) +
	 *      |     (xs[i] == v ? 1 : 0)
	 *      | )
	 */
	static void insert(int[] xs, int n, int v) {
		int index = binarySearch(xs, v);
		int newarr[] = new int[n + 1];
		int i; 
		for (i = 0; i < n + 1; i++) {
			if (i < index)
				newarr[i] = xs[i];
			else if (i == index)
				newarr[i] = v;
			else
				newarr[i] = xs[i - 1];
		}
		xs = newarr;
		
		
		// TODO: Implementeer en schrijf een testsuite!
	}
	
	/**
	 * TODO: Documenteer informeel en formeel!
	 * @param xs
	 */
	static void insertionSort(int[] xs) {
		// TODO: Implementeer en schrijf een testsuite!
	}


}
