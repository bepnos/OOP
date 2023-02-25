package strings;

import java.util.Arrays;

/**
 * Each instance of this class represents a sequence of characters.
 * 
 * @immutable
 */
public class String {
	
	/**
	 * @representationObject
	 */
	private char[] characters;
	
	/**
	 * @inspects | this
	 * @creates | result
	 * @post | result != null
	 */
	public char[] toCharArray() {
		return characters.clone();
	}
	
	/**
	 * @inspects | this
	 * @post | result == toCharArray().length
	 */
	public int length() {
		return characters.length;
	}
	
	/**
	 * @pre | 0 <= index && index < length()
	 * @inspects | this
	 * @post | result == toCharArray()[index]
	 */
	public char charAt(int index) {
		return characters[index];
	}
	
	/**
	 * @pre | characters != null
	 * @mutates |
	 * @post | Arrays.equals(toCharArray(), characters)
	 */
	public String(char[] characters) {
		this.characters = characters.clone();
	}

}