package du.wit.dcsn.comp2000.listapp;

/*
 * extend classes Deck and Hand from Pile. Add instance variables and behaviors (methods) specific to each. 
 * For example, Deck would have a deal() method. As usual, provide constructors,
 * accessor and mutator methods for all instance variables, and a toString() method. 
 * Once you write a card Game class you may determine that these classes need additional instance variables and methods.
 * The default constructor for a Deck will probably instantiate all of the Cards in the Deck.
 *Thoroughly test your Deck and Hand classes before you proceed!
*/

public class Hand extends Pile {

	public String toString() {
		return "";
	}

	public Card getCard() {
		throw new UnsupportedOperationException("Hand does not support getCard()");
	}

	public Card getCard(int index) {
		return cards.get(index);
	}

	public Card playCard(int index) {
		return cards.remove(index);
	}
}
