package du.wit.dcsn.comp2000.listapp;
import java.util.*;
/*
 * Determine a multiple‐player card game that you’d like to implement that is complex enough to require:
 * Objects from your Player, Card, Deck and Hand classes
 * Operations provided in your classes, such as shuffling, sorting, searching, dealing, determine win,... I must approve your game choice.
 * Write a Game class. Include instance variables related to your type of game, such as Players and at least one Deck. Note that instance variables may not be appropriate in Game in all implementation strategies.
 * Depending on the game you are implementing, the methods you have might include initialize() to set up for a new game, and play() to run the game.
 * You have creative freedom to develop additional classes if they make your implementation cleaner and/or more elegant.
 */
/**
 * 
 * @author Jackson Schwarz
 *
 */

 /* Steps for Implementation
 1. Initialize Deck
 2. Initialize Players
 3. Deal the cards to the Players
 4. Start with Player 0
	a. Place down a card
		i. if the card is valid, check to see if its special
			> if it is, apply the special property of the card
				> reverse: reverse the direction of the game
				> skip: skip the next player
				> draw2: the next player draws 2 cards and skip that player
				> draw4: the next player draws 4 cards and skip that player
				> wild: the player that puts down the card chooses the color that the next player will follow
		ii. if the card is invalid, draw a card from the deck
			> if the deck is empty, turn the discard pile -1 card into the new draw deck
	b. Check to see if the player has 1 or less cards
		i. If they have 1 card, display that they have Uno.
		ii. If they have 0 cards, display that they have won and end the game(close the loop)
	c. Move on to the next player according to the direction
  */
public class Game{
	private static ArrayList<Player> players =new ArrayList<Player>();
	private static boolean direction=true;
	private static DrawDeck drawDeck;
	private static DiscardPile discardPile=new DiscardPile();
	private static int currentPlayerIndex=0;

	private static Player currentPlayer;
	private static Player winner;
	public static void main(String[] args) {
		initDeck();
		initPlayers(10);
		dealCards(2);
		playRound();
	}
	/**
	 * Plays the full round of Uno!
	 */
	public static void playRound() {
		for(Player p : players) {
			System.out.println(p.name +"'s turn");
			currentPlayer=players.get(currentPlayerIndex);
			playHand();
			if(p.getCardCount()==0) {
				winner=p;
				winGame();
			}
			if(p.getCardCount()==1) {
				System.out.println(p.name+": \""+p.unoMessage+"\"");
			}
		}
	}
	public static void winGame() {
		System.out.println(currentPlayer.winMessage);
		System.out.println("Congratulations, "+winner.name+" has won!");
		System.exit(0);
	}
	/**
	 * Plays a single hand of the current player
	 */
	public static void playHand() {
		Scanner in=new Scanner(System.in);
		
		while(!currentPlayer.hasValidMove()) {
			System.out.println(currentPlayer.name+" has no valid cards, drawing a card...");
			currentPlayer.drawCard(drawDeck);
			if(drawDeck.getCardCount() == 0) {
				drawDeck=new DrawDeck(discardPile);
			}
		}
		System.out.println(currentPlayer.name+" pick a card(enter a number 1-"+currentPlayer.getCardCount()+")");
		int choiceIndex=in.nextInt();
		currentPlayer.playCard(discardPile, choiceIndex-1);
		checkCard();
		System.out.println(Arrays.toString(discardPile.toArray()));
		nextPlayer();
		
	}
	/**
	 * Display the cards and indices for each card so that the player can choose which card they want
	 */
	private static void displayHand() {
		
	}
	/**
	 * Initialized the DrawDeck instance
	 */
	public static void initDeck(){

		drawDeck=new DrawDeck();
		drawDeck.shuffle();
		discardPile.addCard(drawDeck.getCard());
	}
	/**
	 * Initializes the list of Players, prompting for a name
	 */
	public static void initPlayers(int number){
		for(int i=0;i<number;i++){
			players.add(new Player(new Hand(), "Player"+(i+1)));
		}
	}
	/**
	 * Deals cards to all of the players
	 */
	public static void dealCards(int cardsPerPlayer) {
		for(int i=0;i<cardsPerPlayer;i++) {
			for(Player p : players) {
				p.drawCard(drawDeck);
			}
		}
	}
	/**
	 * Takes all of the Cards in the discard pile and puts them in the draw deck
	 */
	public static void discardDeckToDrawDeck(){
		drawDeck=new DrawDeck(discardPile);
	}

	/**
	 * Move the pointer in the direction to go to the next player in the order.
	 */
	public static void nextPlayer() {
		if(direction) {
			if(currentPlayerIndex == players.size()-2) {
				currentPlayerIndex=0;
			}
			else {
				currentPlayerIndex++;
			}

		}
		else {
			if(currentPlayerIndex == 1) {
				currentPlayerIndex=players.size()-1;
			}
			else {
				currentPlayerIndex--;	
			}

		}
	}
	/**
	 * Checks to see if any Cards played are special. 
	 */
	public static void checkCard() {
		Card c=discardPile.getCard();
		switch(c.face){
			case Wild:
				wild();
				break;
			case Skip:
				skip();
				break;
			case Draw2:
				draw2();
				break;
			case Draw4:
				draw4();
				break;
			case Reverse:
				reverse();
				break;
			default:
				break;
		}
	}
	/**
	 * Reverses the direciton in which players take their turns
	 */
	public static void reverse() {
		System.out.println("Reverse!");
	}
	/**
	 * skips the next player in the rotation
	 */
	public static void skip() {
		System.out.println("Skip!");
		nextPlayer();
	}
	/**
	 * causes the next player to draw 2 cards and skip their turn
	 */
	public static void draw2() {
		System.out.println("Draw2!");
		currentPlayer.drawCard(drawDeck);
		currentPlayer.drawCard(drawDeck);
	}
	/**
	 * Causes the next player to draw 4 cards and skip their turn
	 */
	public static void draw4() {
		System.out.println("Draw4!");
		currentPlayer.drawCard(drawDeck);
		currentPlayer.drawCard(drawDeck);
	}
	/**
	 * Prompts the player to pick a color for the "Wild card" case.
	 */
	public static void wild() {
		System.out.println("Wild!");
		Scanner in=new Scanner(System.in);
		System.out.println("Enter what color you want the Wild to represent(Either RED, YELLOW, GREEN, or BLUE)");
		boolean acceptableColor=true;
		do {
			String color=in.next();
			if(!color.equalsIgnoreCase("RED") &&
			!color.equalsIgnoreCase("BLUE") &&
			!color.equalsIgnoreCase("GREEN") &&
			!color.equalsIgnoreCase("YELLOW")) {
				acceptableColor=false;
			}
			else {
				acceptableColor=true;
			}
		}while(!acceptableColor);

	}
}
