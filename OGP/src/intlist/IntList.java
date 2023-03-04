package intlist;

import java.util.Arrays;

/**
 * Each instance of this class stores a sequence of int values.
 * 
 * @invar | getElements() != null
 * @invar | getLength() == getElements().length
 */
public class IntList {
	
	/**
	 * @invar | elements != null
	 * 
	 * @representationObject
	 */
	private int[] elements;
	
	/**
	 * @creates | result
	 */
	public int[] getElements() { return elements.clone(); } // Vermijdt representation exposure
	
	public int getLength() { return elements.length; }
	
	/**
	 * @pre | 0 <= index && index < getLength()
	 * @inspects | this
	 * @post | result == getElements()[index]
	 */
	public int getElementAt(int index) { return elements[index]; }

	/**
	 * @post | getLength() == 0
	 */
	public IntList() {
		elements = new int[0];
	}
	
	/**
	 * @mutates | this
	 * @post | getLength() == old(getLength()) + 1
	 * @post | Arrays.equals(getElements(), 0, old(getLength()), old(getElements()), 0, old(getLength()))
	 * @post | getElements()[old(getLength())] == element
	 */
	public void add(int element) {
		elements = Arrays.copyOf(elements, elements.length + 1);
		elements[elements.length - 1] = element;
	}
	
	/**
	 * @pre | getLength() > 0
	 * @mutates | this
	 * @post | Arrays.equals(getElements(), 0, getLength(), old(getElements()), 0, getLength())
	 */
	public void removeLast() {
		elements = Arrays.copyOf(elements, elements.length - 1);
	}
}