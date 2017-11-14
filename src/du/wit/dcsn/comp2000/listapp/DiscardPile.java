package du.wit.dcsn.comp2000.listapp;

public class DiscardPile extends Pile {

	@Override
	public void addCard(Card card) {
		super.addCard(card);
	}

	@Override
	public Card getCard() {
		return cards.get(cards.size() - 1);
	}
}