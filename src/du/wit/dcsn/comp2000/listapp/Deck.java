package du.wit.dcsn.comp2000.listapp;

import java.util.ArrayList;

/*
 * extend classes Deck and Hand from Pile. Add instance variables and behaviors (methods) specific to each. 
 * For example, Deck would have a deal() method. As usual, provide constructors,
 * accessor and mutator methods for all instance variables, and a toString() method. 
 * Once you write a card Game class you may determine that these classes need additional instance variables and methods.
 * The default constructor for a Deck will probably instantiate all of the Cards in the Deck.
 *Thoroughly test your Deck and Hand classes before you proceed!
*/

public abstract class Deck extends Pile {

	Deck() {

	}

	public String toString() {
		return "";
	}

	public void shuffle() {

	}

	public void deal(ArrayList<Player> players) {

	}
}
