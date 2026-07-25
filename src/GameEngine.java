import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;


public class GameEngine {
    public static final String RED = "\u001B[31m";
    public static final String RESET = "\u001B[0m";

    private List<Participant> participants; // i am using dummy values so these wont work
    private Deck deck; // i am using dummy values so these wont work
    private HouseRules rules; // i am using dummy values so these wont work

    public GameEngine() {
        participants = new ArrayList<>();
        deck = new Deck();
        rules = new HouseRules();
    }


    public void startGame() {
        mainMenu();

    }


    public void playRound() {
        System.out.println("round is played!");
    }

    public void resolveWinner() {
        System.out.println("the winner is you!");
    }


    // private methods #####################################################################

    private void mainMenu() {
        int selection = 0;

        while (selection != -1) {
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
                    3. quit
                    
                    """);
            selection = input();
            switch (selection) {
                case 1:
                    System.out.println("case 1");
                    break;
                case 2:
                    System.out.println("case 2");
                    optionsMenu();
                    break;
                case 3:
                    System.out.println("case 3");
                    selection = -1;
                    break;
                default:
                    System.out.println("default case");
                    break;
            }
        }
    }

    private void optionsMenu() {
        int selection = 0;
        while (selection != -1) {
            System.out.print("""
                    Choose an option:
                    1. Modify number of decks used
                    2. Modify dealer hit on soft 17
                    3. Go back
                    
                    """);
            selection = input();
            switch (selection) {
                case 1:
                    System.out.println("case 1");
                    deckAmount();
                    break;
                case 2:
                    System.out.println("case 2");
                    dealerHit17();
                    break;
                case 3:
                    System.out.println("case 3");
                    selection = -1;
                    break;
            }
        }
    }

    private void deckAmount() {
        int deck_amount = 0;
        System.out.print("How many decks do you want?");
        deck_amount = input();
        System.out.println("Deck amount is now " + deck_amount);
    }

    private void dealerHit17() {
        boolean dealerhit17;
        int selection;
        System.out.print("""
                Hit on soft 17?
                1. Enable
                2. Disable
                """);
        selection = input();
        if (selection == 1) {
            //rules.isHitSoft17(true);
            System.out.print("Dealer hit on soft 17 is now enabled");
            dealerhit17 = true;
        } else if (selection == 2) {
            //rules.isHitSoft17(false);
            System.out.print("Dealer hit on soft 17 is now disabled");

            dealerhit17 = false;
        }
    }

    private int input() {
        Scanner player_input = new Scanner(System.in);
        int selection = 0;
        try {
            selection = Integer.parseInt(player_input.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input! Please enter a number.");
        }
        return selection;
    }


}
