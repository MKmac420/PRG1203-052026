import java.util.ArrayList;
import java.util.List;

/*
EVERY SINGLE PRINT STATEMENT IN HERE IS FOR TESTING ONLY.
ONLY GRAPHICS.JAVA CAN HANDLE OUTPUT
 */


public class GameEngine {
    private List<Participant> participants;
    private Deck deck;
    private HouseRules rules;

    private int deck_amount = 4; // default if user doesnt set
    private boolean dealerhit17 = false; // also default

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

    private void displayParticipantHand(Participant p) {


    }


    private void Start() { // this is the actual gamplay loop
        Boolean playing =  true;

        participants.clear();

        deck.initialize(rules.getNumberOfDecks());
        deck.shuffle();


        GUI.playerNameInput();
        participants.add(new Player(Input.readString()));

        participants.add(new Dealer("Dealer")); // dealer is always last


        while (playing) {
            playRound();

            System.out.println("want to keep playing? 1.yes 2.no"); // temp
            if (Input.readInt() == 2) {
                playing = false;
            }
        }





        /*
        note.
        this will loop until player decides they dont want to play anymore

        make a while loop to keep the game running

         */


    }

    public void playRound() { //t temp
        if (deck.isEmpty()) {
            deck.initialize(rules.getNumberOfDecks());
            deck.shuffle();

        }
        for (Participant p : participants) {
            p.reset();
        }

        for (int round = 0; round < 2; round++) {
            for (Participant p : participants) {
                Card card = deck.dealCard();

                if (p.isDealer() && round == 1) {
                    card.setHidden(true);
                }

                p.getHand().addCard(card);
            }
        }

        for (Participant p : participants) {
            p.playTurn(deck, rules);
        }

        resolveWinner(); // checks if anyone won or not

    }

    public void resolveWinner() { // temp
        Participant dealer = participants.getLast(); // dealer is always last

        for (Card card : dealer.getHand().getCards()) {
            card.setHidden(false);
        }

        int dealerScore = dealer.getHand().getScore();
        boolean dealerBusted = dealer.getHand().isBusted();

        for (Participant p : participants) {
            if (!p.isDealer()) {
                int playerScore = p.getHand().getScore();
                boolean playerBusted = p.getHand().isBusted();


                if (playerBusted) {
                    System.out.println("player lose bcs busted!");
                }
                else if (dealerBusted) {
                    System.out.println("player win bcs dealer busted!");
                }
                else if (playerScore > dealerScore) {
                    System.out.println("player win!");
                }
                else if (playerScore < dealerScore) {
                    System.out.println("player lose!");
                }
                else {
                    System.out.println("Tie bcs same score");
                }
            }
        }

    }


}
