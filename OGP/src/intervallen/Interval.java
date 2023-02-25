package intervallen;

// Stappenplan documenteren API data-abstractie:
//
// 1. Getters declaren (naam en return type) =
//    rauwe abstractetoestandsruimte definiëren
// 2. Geldige abstractetoestandsruimte definiëren =
//    abstractetoestandsinvarianten noteren
// 3. Documenteren van constructoren en mutatoren
//
// 

/**
 * abstractetoestandsinvariant
 * 
 * @invar | getOndergrens() <= getBovengrens()
 */
class Interval {
	/**
	 * representatie-invariant
	 * 
	 * @invar | ondergrens <= bovengrens
	 */
	private int ondergrens;
	private int bovengrens;
	
	int getOndergrens() {
		return ondergrens;
	}
	int getBovengrens() {
		return bovengrens;
	}

	/**
	 * @pre | interval2 != null
	 * @inspects | this, interval2
	 * @post | result != null
	 * @creates | result
	 * @post | result.getOndergrens() == this.getOndergrens() + interval2.getOndergrens()
	 * @post | result.getBovengrens() == this.getBovengrens() + interval2.getBovengrens()
	 */
	Interval telOp(Interval interval2) {
		return new Interval(
				ondergrens + interval2.ondergrens,
				bovengrens + interval2.bovengrens);
	}

	/**
	 * @pre | ondergrens <= bovengrens
	 * @post | getOndergrens() == ondergrens
	 * @post | getBovengrens() == bovengrens
	 */
	Interval(int ondergrens, int bovengrens) {
		this.ondergrens = ondergrens;
		this.bovengrens = bovengrens;
	}
	
	/**
	 * @pre | 0 <= lengte
	 * @mutates | this
	 * @post | getOndergrens() == old(getOndergrens())
	 * @post | getBovengrens() == getOndergrens() + lengte
	 */
	void setLengte(int lengte) {
		bovengrens = ondergrens + lengte;
	}

}
