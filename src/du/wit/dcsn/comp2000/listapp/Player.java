package du.wit.dcsn.comp2000.listapp;
/* 
 * Write a Player class. Include instance variables related to players, such as name, hand (instance of your Hand class), and score. 
 * Include methods related to players. These may also be added later as you write your Game class.
 * Thoroughly test your Player class before you proceed.
 */

public class Player {

	private Hand hand;
	public final String name;
	public final String unoMessage;
	public final String winMessage;
	
	Player(Hand h, String n){
		hand = h;
		name = n;
		unoMessage = "Uno!";
		winMessage = "I'm good enough to win at uno, but not good enough to have a custom win message";
	}
	
	Player(Hand h, String n, String um, String wm){
		hand = h;
		name = n;
		unoMessage = um;
		winMessage = wm;
	}
	
	
	public boolean drawCard(DrawDeck drawDeck){
		if(drawDeck.isEmpty()) return false;
		hand.addCard(drawDeck.getCard());
		return true;
	}
	
	
	
	public boolean playCard(DiscardPile discardPile, int cardIndex){
		if(hand.toArray()[cardIndex].compareTo(discardPile.getCard())) { //check if card is vaild here, currently no method for comparing top card with card played
			discardPile.addCard(hand.playCard(cardIndex));
			return true;
		}
		return false;
	}
	
	public Hand getHand() {
		return hand;
	}
	public boolean hasValidMove(DiscardPile discardPile){
		for(int i = 0; i < hand.toArray().length; i++){
			Card currentCard = hand.toArray()[i];
			if(!currentCard.compareTo(discardPile.getCard())){ //check if card is invaild here, currently no method for comparing top card with card played
				return false;
			}
		}
		return true;
	}
	
	public int getCardCount(){
		return hand.getCardCount();
	}
	
}
