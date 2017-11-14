package du.wit.dscn.comp2000.listapp;
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
	private static int currentNumber;
	private static String currentColor;
	public static void main(String[] args) {
		
	}
	/**
	 * Plays the full round of Uno!
	 */
	public static void playRound() {
		Player currentPlayer=players.get(currentPlayerIndex);
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
	 * Checks to see if the player needs to draw from the deck, or if any of the cards are special. 
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
		
	}
	/**
	 * Causes the next player to draw 4 cards and skip their turn
	 */
	public static void draw4() {
		
	}
	/**
	 * Prompts the player to pick a color for the "Wild card" case.
	 */
	public static void wild() {
		
	}
}
