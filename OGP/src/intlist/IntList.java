package intlist;

/**
 * 
 * each instance of this class represents a sequence of integers 
 *
 * @immutable
 */

public class IntList {
	
	/**
	 * representation object
	 */
	private int[] numbers;
	
	public int[] toArray() {
		return numbers.clone();
	}	
	public int length() {
		return numbers.length;
	}
	
	public int numberAt(int index) {
		return numbers[index];
	}
	
	public IntList addNumber(int getal) {
		int lengte = this.length();
		int[] newarr = new int[lengte + 1];
		int i;
		for (i = 0; i < lengte; i++) {
			newarr[i] = numberAt(i);
		}
		newarr[lengte] = getal; 
		IntList nieuweLijst = new IntList(newarr);
		return nieuweLijst;
	}
	
	public IntList(int[] numbers) {
		this.numbers = numbers.clone();
	}
}
