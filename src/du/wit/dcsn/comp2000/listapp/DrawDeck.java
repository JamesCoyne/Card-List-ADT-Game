package du.wit.dcsn.comp2000.listapp;

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

}