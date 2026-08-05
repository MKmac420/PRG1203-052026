public class Card {

	
	private String suit;
	private String rank;
	private boolean isHidden;
	
	//Constructor
	public Card(String suit, String rank) {
		this.suit = suit;
		this.rank = rank;
		this.isHidden = false; //Allows the cards to start face up by default
	}
	
	public String getRank() {
		return suit == null ? "" : rank; //Returns the suit of the card.
	}
	
	//Handles the point values for cards
	public int getValue() {
		switch (rank) {
		
		case "Jack":
		case "Queen":
		case "King":
		case "10":
			return 10;
		case "Ace":
			return 11; //Hand.java handles reducing Ace to 1 if score is over 21
		default:
			return Integer.parseInt(rank);
		}
	}
	
	// Checks if the card is face down
	
    public boolean isHidden() {
        return isHidden;
    }

    // Sets whether the card is face down or face up
    public void setHidden(boolean hidden) {
        this.isHidden = hidden;
    }

    // Converts the card to a string
    @Override
    public String toString() {
        if (isHidden) {
            return "[Hidden Card]";
        }
        return rank + " of " + suit;
    }
}
