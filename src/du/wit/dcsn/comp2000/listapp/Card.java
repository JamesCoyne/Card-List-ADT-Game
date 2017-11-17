package du.wit.dcsn.comp2000.listapp;

public class Card {
	
	public enum Face {
		SKIP("Skip", 10), 
		REVERSE("Reverse", 11), 
		DRAW_TWO("Draw Two", 12), 
		DRAW_FOUR("Draw Four", 13);
		
		public final String displayName;
		public final int value;
		
		private Face(String faceDisplayName, int faceValue) {
			this.displayName = faceDisplayName;
			this.value = faceValue;
		}
		
		public static Face parse(int i) throws Exception {
			switch(i) {
				case 10:
					return SKIP;
				case 11:
					return REVERSE;
				case 12:
					return DRAW_TWO;
				case 13:
					return DRAW_FOUR;
				default:
					throw new Exception("Invalid Face");
			}
		}
	}
	
	public enum Color {
		WILD("Wild", 0),
		RED("Red", 1),
		YELLOW("Yellow", 2),
		GREEN("Green", 3),
		BLUE("Blue", 4);
		
		public final String displayName;
		public final int value;
		
		private Color(String colorDisplayName, int colorValue) {
			this.displayName = colorDisplayName;
			this.value = colorValue;
		}
		
		public static Color parse(int i) throws Exception {
			switch(i) {
				case 0:
					return WILD;
				case 1:
					return RED;
				case 2:
					return YELLOW;
				case 3:
					return GREEN;
				case 4:
					return BLUE;
				default:
					throw new Exception("Invalid Color");
			}
		}
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
	
}