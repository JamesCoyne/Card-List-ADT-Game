package du.wit.dcsn.comp2000.listapp;

import java.util.ArrayList;

/**
 * The Deck that all players draw cards from. Access is restricted to popping cards off of the top (size() - 1)
 * 
 * @author Kevin Humphreys
 */

public class DrawDeck extends Pile {

	public DrawDeck() {
		super();
		for (Card.Color color : Card.Color.values()) {
			if (color != Card.Color.Wild) {
				for (Card.Face faceVal : Card.Face.values()) {
					if (Card.Face.isNumber(faceVal) && faceVal != Card.Face.Zero) {
						if (!Card.Face.isWild(faceVal)) {
							addCard(new Card(color, faceVal));
						} else {
							addCard(new Card(Card.Color.Wild, faceVal));
						}
					}
					if (!Card.Face.isWild(faceVal)) {
						addCard(new Card(color, faceVal));
					}
				}
			}
		}
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

	private static void testDrawDeck()
	{
		System.out.println("==== Testing DrawDeck ====");
		testConstructors();
		testGetCard();
	}
	private static void testConstructors() {
		System.out.println("---- Testing DrawDeck constructors ----");
		System.out.println("---- Testing new DrawDeck() ----");
		DrawDeck deck = new DrawDeck();
		System.out.println("New DrawDeck created: " + deck);

		System.out.println("---- Testing new DrawDeck(DiscardPile pile) ----");

		DiscardPile discard = new DiscardPile();
		for (int i = 0; i < 10; i++) {
			discard.addCard(deck.getCard());
		}
		System.out.println("DiscardPile contents: " + discard.toString());
		deck = new DrawDeck(discard);
		System.out.println("DrawDeck contents: " + deck);
	}

	private static void testGetCard() {
		System.out.println("---- Testing getCard() ----");
		DrawDeck deck = new DrawDeck();
		System.out.println("DrawDeck contents: " + deck);
		System.out.println("Card removed: " + deck.getCard());
		System.out.println("DrawDeck after getCard(): " + deck);
	}

	public String toString() {
		return cards.toString();
	}

	public static void main(String[] args) {
		testDrawDeck();
	}
}