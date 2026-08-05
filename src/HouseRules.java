public class HouseRules {

    private int numberOfDecks;
    private boolean hitSoft17;

    // Constructor 
    public HouseRules() {
        this.numberOfDecks = 1;
        this.hitSoft17 = true;
    }


    public HouseRules(int numberOfDecks, boolean hitSoft17) {
        this.numberOfDecks = numberOfDecks;
        this.hitSoft17 = hitSoft17;
    }

    // Getter for number of decks
    public int getNumberOfDecks() {
        return numberOfDecks;
    }

    // Getter for Soft 17 rule
    public boolean isHitSoft17() {
        return hitSoft17;
    }
}
