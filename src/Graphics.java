import java.util.List;

public class Graphics {

    /*
    The main goal of this class is to handle ALL console output
     */

    private static final String SPADES = "♠";
    private static final String HEARTS = "♥";
    private static final String DIAMONDS = "♦";
    private static final String CLUBS = "♣";


    public void displayMainMenu() {
        System.out.print("""
                
                   Welcome to...
                   _______  ______ _      ______ ___  __   _   _____  ____ _____ ______
                  / ___/ / / / __ \\ | /| / / __ `/ / / /  | | / / _ \\/ __ `/ __ `/ ___/
                 (__  ) /_/ / / / / |/ |/ / /_/ / /_/ /   | |/ /  __/ /_/ / /_/ (__  )\s
                /____/\\__,_/_/ /_/|__/|__/\\__,_/\\__, /    |___/\\___/\\__, /\\__,_/____/ \s
                                               /____/              /____/             \s
                """);
        // Ascii art source here
        // https://patorjk.com/software/taag/#p=display&f=Slant&t=sunway+vegas&x=none&v=4&h=4&w=80&we=false

        System.out.print("""
                Pick an option:
                1. Start game
                2. Modify house rules
                3. How to play
                4. quit
                
                """);
    }

    public void keepPlaying() {
        System.out.println("Do you want to keep playing?\n1. Yes\n2. No");
    }

    public void displayOptionsMenu() {
        System.out.print("""
                Choose an option:
                1. Modify number of decks used
                2. Modify dealer hit on soft 17
                3. Go back
                
                """);
    }

    public void displayHelpMenu() {
        System.out.print("""
                #########################
                # How to play Blackjack #
                #########################
                
                1. This is a card game played using a 52 card deck
                2. cards 2-10 are worth their face value
                3. cards K, Q, and J are worth 10
                4. The A card is worth 1 or 11 depending on which value is more favorable
                5. The goal is to get a cummulative hand value higher than the dealer
                6. If you go over 21, you bust and lose
                7. If the dealer goes above 21, you win
                8. The default amount of decks used is 4
                9. The dealer does not hit on 17 by default
                10. All cards are tracked, try keeping track, it might give you an edge...
                
                Press Enter to go back.
                """);
    }

    public void displayDeckAmountMenu() {
        System.out.print("How many decks do you want?");
    }

    public void displayDeckAmountMenu(int deckAmount) {
        System.out.println("Deck amount is now " + deckAmount);
    }

    public void displayDealerHit17Menu() {
        System.out.print("""
                Hit on soft 17?
                1. Enable
                2. Disable
                """);
    }

    public void displayDealerHit17Menu(boolean dealerHit) {
        if (dealerHit) {
            System.out.println("Dealer hit on soft 17 is now enabled");
        } else {
            System.out.println("Dealer hit on soft 17 is now disabled");
        }
    }

    public void promptPlayerName() {
        System.out.println("Enter your name (max 20 characters long):");
    }


    public String formatCard(String rank, String suit, boolean notHidden) {
        if (notHidden) {

            String symbol = suit;

            symbol = switch (suit) {
                case "Spades" -> SPADES;
                case "Hearts" -> HEARTS;
                case "Diamonds" -> DIAMONDS;
                case "Clubs" -> CLUBS;
                default -> symbol;
            }; // this is basically switch catch but newer.

            return String.format("[ %s %s ]", rank, symbol);

        } else {
            return ("[ ? ? ]");
        }

    }

    public void displayHand(String name, List<Card> cards, int score) {
        boolean hasHiddenCards = false;


        System.out.printf("%s's Hand: ", name);

        for (Card card : cards) {
            String cardVisual = formatCard(card.getRank(), card.getSuit(), !card.isHidden());
            System.out.print(cardVisual + " ");

            if (card.isHidden()) {
                hasHiddenCards = true;
            }
        }
        if (hasHiddenCards) { //
            System.out.println(" (Total: ?)");
        }
        else System.out.printf(" (Total: %s)\n", score);
    }

    public void declareWinner(int playerScore, boolean playerBusted, int dealerScore, boolean dealerBusted, String playerName) {

        if (playerBusted) {
            System.out.printf("%s loses. (%s busted)\n", playerName, playerName);
        }
        else if (dealerBusted) {
            System.out.printf("%s wins! (dealer busted)\n", playerName);
        }
        else if (playerScore > dealerScore) {
            System.out.printf("%s wins! (%s's hand value is higher)\n", playerName, playerName);
        }
        else if (playerScore < dealerScore) {
            System.out.printf("%s loses! (dealer's hand value is higher)\n", playerName);
        }
        else {
            System.out.println("Tie! (hand value is equal)");
        }

    }


}
