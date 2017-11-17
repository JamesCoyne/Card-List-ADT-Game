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
public class Game{
	private static ArrayList<Player> players =new ArrayList<Player>();
	private static boolean direction;
	private static DrawDeck drawDeck;
	private static DiscardPile discardDeck;
	private static int currentPlayerIndex=0;

	public static void main(String[] args) {
		
	}
	/**
	 * Plays the full round of Uno!
	 */
	public static void playRound() {
		Player currentPlayer=players.get(currentPlayerIndex);
	}
	/**
	 * Initialized the DrawDeck instance
	 */
	public static void initDeck(){

		//init cards for each color 1 - 13
		for(int color = 1; color < 3; color++){
			for(int face = 1; face < 13; face++){
				drawDeck.addCard(new Card(color, face));
			}
		}

		//init cards for each color 0 - 13
		for(int color = 1; color < 3; color++){
			for(int face = 0; face < 13; face++){
				drawDeck.addCard(new Card(color, face));
			}
		}
		//init 4 cards wild and wild draw 4
		for(int i = 0; i < 4; i++){
			drawDeck.addCard(new Card(0, 14));
			drawDeck.addCard(new Card(0, 15));
		}
	}
	/**
	 * Initializes the list of Players, prompting for a name
	 */
	public static void initPlayers(){

	}
	/**
	 * Takes all of the objects 
	 */
	public static void discardDeckToDrawDeck(){

	}
	/**
	 * Plays a single hand of the current player
	 */
	public static void playHand() {
		
	}
	/**
	 * Move the pointer in the direction to go to the next player in the order.
	 */
	public static void nextPlayer() {
		if(direction) {
			currentPlayerIndex++;
		}
		else {
			currentPlayerIndex--;
		}
	}
	/**
	 * Checks to see if any Cards played are special. 
	 */
	public static void checkCard() {
		
	}
	/**
	 * Reverses the direciton in which players take their turns
	 */
	public static void reverse() {
		direction = !direction;
	}
	/**
	 * skips the next player in the rotation
	 */
	public static void skip() {
		nextPlayer();
		nextPlayer();
	}
	/**
	 * causes the next player to draw 2 cards and skip their turn
	 */
	public static void draw2() {
		//if player.drawCard() == false, then reinitialize discardPile into drawDeck, and do player.drawCard() again
	}
	/**
	 * Causes the next player to draw 4 cards and skip their turn
	 */
	public static void draw4() {
		draw2();
		draw2();	
	}
	/**
	 * Prompts the player to pick a color for the "Wild card" case.
	 */
	public static void wild() {
		
	}
}
