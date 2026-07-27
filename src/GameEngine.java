import java.util.ArrayList;
import java.util.List;

/* TODO
the actual blackjack engine
polishing the input stuff
well, many things
*/

public class GameEngine {
    private List<Participant> participants;
    private Deck deck;
    private HouseRules rules;

    private int deck_amount;
    private boolean dealerhit17;

    Graphics GUI = new Graphics();
    Input Input = new Input();


    public GameEngine() {
        participants = new ArrayList<>();
        deck = new Deck();
        rules = new HouseRules(4, false);
    }


    public void startGame() {
        mainMenu();
    }


    public void playRound() { //t temp
        System.out.println("round is played!");
    }

    public void resolveWinner() { // temp
        System.out.println("the winner is you!");
    }


    // private methods ######################

    private void mainMenu() { // this is the main menu
        int selection = 0;

        while (selection != -1) {
        GUI.displayMainMenu();
            selection = Input.readInt();

            switch (selection) {
                case 1:
                    System.out.println("case 1");
                    Start();
                    break;
                case 2:
                    System.out.println("case 2");
                    optionsMenu();
                    break;
                case 3:
                    System.out.println("case 3");
                    helpMenu();
                    break;
                case 4:
                    System.out.println("case 4");
                    selection = -1;
                    break;
                default:
                    System.out.println("default case");
                    break;
            }
        }
    }

    private void optionsMenu() { // this is the options menu
        int selection = 0;
        while (selection != -1) {
            GUI.displayOptionsMenu();
            selection = Input.readInt();

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
                    this.rules = new HouseRules(deck_amount, dealerhit17);
                    selection = -1;
                    break;
            }
        }
    }

    private void helpMenu() { // all the help will be stored here
        GUI.displayHelpMenu();
        Input.promptEnter();
    }

    private void deckAmount() { // this menu changes the deck amount house rule
        GUI.displayDeckAmountMenu();
        deck_amount = Input.readInt();
        GUI.displayDeckAmountMenu(deck_amount);
    }

    private void dealerHit17() { // this menu changes whether the dealer hits on a soft 17 or not
        int selection;
        GUI.displayDealerHit17Menu();
        selection = Input.readInt();
        if (selection == 1) { // dealer will hit at soft 17
            //rules.isHitSoft17(true);
            this.dealerhit17 = true;
            GUI.displayDealerHit17Menu(dealerhit17);

        } else if (selection == 2) { // dealer will NOT hit at soft 17
            //rules.isHitSoft17(false);
            this.dealerhit17 = false;
            GUI.displayDealerHit17Menu(dealerhit17);

        }
    }




    private void Start() { // this is the actual gamplay loop
        deck.initialize(rules.getNumberOfDecks());
        deck.shuffle();

        participants.clear();
        participants.add(new Player(Input.readString()));
        participants.add(new Dealer("Dealer"));

        /*
        note.
        this will loop until player decides they dont want to play anymore
         */


    }


}
