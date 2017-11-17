package du.wit.dcsn.comp2000.listapp;

public class Card {

	public enum Face {
		Zero, One, Two, Three, Four, Five, Six, Seven, Eight, Nine, Skip, Reverse, Draw2, Draw4, Wild;

		public static boolean isNumber(Face face) {
			return face != Skip && face != Reverse && face != Draw2 && face != Draw4 && face != Wild;
		}

		public static boolean isWild(Face face) {
			return face == Wild || face == Draw4;
		}
	}

	public enum Color {
		Wild, Red, Green, Blue, Yellow
	}

	public final Face face;
	public final Color color;

	public Card(Color color, Face face) {
		this.color = color;
		this.face = face;
	}

	/*
	 * compareTo
	 * compares two cards together by color || num 
	 */

	public boolean compareTo(Card c2) {
		return this.color.equals(c2.color) || this.face.equals(c2.face);
	}

	public String toString() {
		return "[" + color + " " + face + "]";
	}

}