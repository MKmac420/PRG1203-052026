public class Graphics {

    private final String SPADE = "♠";
    private final String HEART = "♥";
    private final String DIAMOND = "♦";
    private final String CLUBS = "♣";


    public void displayMainMenu() {
        System.out.print("""
                    
                       Welcome to...
                       _______  ______ _      ______ ___  __   _   _____  ____ _____ ______
                      / ___/ / / / __ \\ | /| / / __ `/ / / /  | | / / _ \\/ __ `/ __ `/ ___/
                     (__  ) /_/ / / / / |/ |/ / /_/ / /_/ /   | |/ /  __/ /_/ / /_/ (__  )\s
                    /____/\\__,_/_/ /_/|__/|__/\\__,_/\\__, /    |___/\\___/\\__, /\\__,_/____/ \s
                                                   /____/              /____/             \s
                    """);
        //https://patorjk.com/software/taag/#p=display&f=Slant&t=sunway+vegas&x=none&v=4&h=4&w=80&we=false

        System.out.print("""
                    Pick an option:
                    1. Start game
                    2. Modify house rules
                    3. How to play
                    4. quit
                    
                    """);
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

    public void displayDeckAmountMenu(int deck_amount) {
        System.out.println("Deck amount is now " + deck_amount);
    }

    public void displayDealerHit17Menu() {
        System.out.print("""
                Hit on soft 17?
                1. Enable
                2. Disable
                """);
    }

    public void displayDealerHit17Menu(boolean dealer_hit) {
        if (dealer_hit) {
            System.out.println("Dealer hit on soft 17 is now enabled");
        }
        else {
            System.out.println("Dealer hit on soft 17 is now disabled");
        }
    }

    public void playerNameInput() {
        System.out.println("Enter your name (max 20 characters long):");
    }



    public String formatCard(String rank, String suit, boolean notHidden) {
        if (notHidden) {
            return String.format("[ %s %s ]", rank, suit);

        }
        else {
            return ("[ ? ? ]");
        }

    }
















}
