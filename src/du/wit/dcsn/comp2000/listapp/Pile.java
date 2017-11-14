package du.wit.dcsn.comp2000.listapp;
/*
Write a Pile class to represent a general pile of cards. Your pile must be/utilize a List. You can use any List implementation (your ADT or a Java library class) but you must use only List methods (Iterator methods are included if desirable).
As usual, provide constructors, accessor and mutator methods for all instance variables, and a toString() method Include methods representing operations on piles of cards, such as
 Shuffling and Sorting
 Removing and adding cards.
 Searching
 Splitting
 Grouping by face/rank or suit.
 Other?
Other methods may be added later if you determine that you need them.
Thoroughly test your Pile class methods before you proceed (will save you time and frustration later).
 */

import java.util.ArrayList;

public abstract class Pile {

	protected ArrayList<Card> cards;

	public Pile() {

	}


	public void addCard(Card card) {
		cards.add(card);
	}

	public Card[] toArray() {
		return cards.toArray(new Card[cards.size()]);
	}

	public boolean isEmpty() {
		return cards.isEmpty();
	}

	public String toString() {
		return cards.toString();
	}

	public int getCardCount()
	{
		return cards.size();
	}
	
	public abstract Card getCard();
}
