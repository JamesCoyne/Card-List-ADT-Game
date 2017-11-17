package du.wit.dcsn.comp2000.listapp;

import java.util.ArrayList;

/**
 * The Deck that all players draw cards from. Access is restricted to popping cards off of the top (size() - 1)
 * 
 * @author Kevin Humphreys
 */
public class DrawDeck extends Deck {

	public DrawDeck() {
		System.err.println("Load from the config!");
		assert false;
	}

	public DrawDeck(DiscardPile deck) {
		super();
		for (Card c : deck.cards) {
			addCard(c);
		}
		shuffle();
	}

	public Card getCard() {
		return cards.remove(cards.size() - 1);
	}

	public void shuffle() {
		for (int i = 0; i < cards.size(); i++) {
			cards.set(i, cards.set((int) (Math.random() * cards.size()), cards.get(i)));
		}
	}

	public void deal(ArrayList<Player> players) {
		for (int i = 0; i < 7; i++) {
			for (Player p : players) {
				p.drawCard(this);
			}
		}
	}

	private void testConstructor() {
		System.out.println("---- Testing DrawDeck constructors ----");
		System.out.println("---- Testing new DrawDeck() ----");
		DrawDeck deck = new DrawDeck();
		System.out.println("New DrawDeck created: " + deck);

		System.out.println("---- Testing new DrawDeck(DiscardPile pile ----");
		//deck = new DrawDeck(
	}

	public static void main(String[] args) {

	}
}