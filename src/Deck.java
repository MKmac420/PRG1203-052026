import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
 
    private List<Card> cards;

   
    public Deck() {
        this.cards = new ArrayList<>();
    }

    // Generates 52 cards multiplied by numberOfDecks
    public void initialize(int numberOfDecks) {
        cards.clear(); // Clear existing cards before rebuilding

        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};

        // Loop for the total number of decks specified
        for (int d = 0; d < numberOfDecks; d++) {
            for (String suit : suits) {
                for (String rank : ranks) {
                    cards.add(new Card(suit, rank));
                }
            }
        }
    }

    // Shuffles the remaining cards in the deck
    public void shuffle() {
        Collections.shuffle(cards);
    }

    // Deals the top card from the deck
    public Card dealCard() {
        if (isEmpty()) {
            return null; // Check if deck is out of cards
        }
        return cards.remove(0); // Removes and returns card at index 0 (top of deck)
    }

    // Checks if the deck is empty
    public boolean isEmpty() {
        return cards.isEmpty();
    }
}
