package timeofday;
/**
 * each instance of this class represents a certain time during the day
 * 
 *@invar | 0 <= getMinutes() && getMinutes() < 60
 *@invar | 0 <= getHours() && getHours() < 24
 *
 */

class TimeOfDay {
	/**
	 * 
	 */
	private int minutesSinceMidnight;

	int getMinutes() {
		return minutesSinceMidnight % 60; 
	}
	
	int getHours() {
		return minutesSinceMidnight / 60;
	}
	/**
	 * Initialises this instance with the given hours and minutes
	 * 
	 * @pre | 0 <= hours && hours < 24
	 * @pre | 0 <= minutes && minutes < 60
	 * @post | getMinutes() == minutes
	 * @post | getHours() == hours 
	 * 
	 */
	TimeOfDay(int hours, int minutes){
		this.minutesSinceMidnight = hours*60 + minutes;
	}
	

	/**
	 * Sets this instance minutes to the given minutes
	 * 
	 * @pre | 0 <= minutes && minutes < 60 
	 * @mutates | this
	 * @post | getMinutes() == minutes
	 * @post | getHours() == old(getHours())
	 *
	 */
	
	public void setMinutes(int minutes) {
		int hours = this.minutesSinceMidnight / 60; 
		this.minutesSinceMidnight = hours * 60 + minutes; 
	}

	/**
	 * Sets this instance minutes to the given minutes
	 * 
	 * @pre | 0 <= hours && hours < 24
	 * @mutates | this
	 * @post | getMinutes() == old(getMinutes())
	 * @post | getHours() == hours
	 *
	 */
	public void setHours(int hours) {
		int minutes = this.minutesSinceMidnight % 60; 
		this.minutesSinceMidnight = hours * 60 + minutes; 
	} 
	
	
}
