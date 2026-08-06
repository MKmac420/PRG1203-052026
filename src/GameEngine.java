import java.util.ArrayList;
import java.util.List;


public class GameEngine {

    /*
    the main goal of this class is the handle the menu and gameplay loop
     */

    private List<Participant> participants;
    private Deck deck;
    private HouseRules rules;

    private int deckAmount = 4; // default if user doesnt set
    private boolean dealerHit17 = false; // also default

    Graphics gui = new Graphics();
    Input input = new Input();


    public GameEngine() {
        participants = new ArrayList<>();
        deck = new Deck();
        rules = new HouseRules(4, false);
    }


    public void startGame() {
        mainMenu();
    }


    // private methods ######################

    private void mainMenu() {
        int selection;

        while (true) {
            gui.displayMainMenu();
            selection = input.readInt(4);

            switch (selection) {
                case 1 -> start();
                case 2 -> optionsMenu();
                case 3 -> helpMenu();
                case 4 -> {
                    return;
                }
            }
        }
    }

    private void optionsMenu() {
        int selection = 0;
        while (true) {
            gui.displayOptionsMenu();
            selection = input.readInt(3);

            switch (selection) {
                case 1 -> configDeckAmount();
                case 2 -> configDealerHit17();
                case 3 -> {
                    rules = new HouseRules(deckAmount, dealerHit17);
                    return;
                } //saves changes and exits
            }

        }
    }

    private void helpMenu() { // all the help will be stored here
        gui.displayHelpMenu();
        input.promptEnter();
    }

    private void configDeckAmount() { // this menu changes the deck amount house rule
        gui.displayDeckAmountMenu();
        deckAmount = input.readInt();
        gui.displayDeckAmountMenu(deckAmount);
    }

    private void configDealerHit17() { // this menu changes whether the dealer hits on a soft 17 or not
        int selection;
        gui.displayDealerHit17Menu();
        selection = input.readInt(2);
        if (selection == 1) { // dealer will hit at soft 17
            //rules.isHitSoft17(true);
            this.dealerHit17 = true;
            gui.displayDealerHit17Menu(dealerHit17);

        } else if (selection == 2) { // dealer will NOT hit at soft 17
            //rules.isHitSoft17(false);
            this.dealerHit17 = false;
            gui.displayDealerHit17Menu(dealerHit17);

        }
    }

    private void displayParticipantHand(Participant p) {
        gui.displayHand(p.getName(), p.getHand().getCards(), p.getHand().getScore());
    }


    private void start() { // this is the actual gamplay loop
        boolean playing =  true;

        participants.clear();

        deck.initialize(rules.getNumberOfDecks());
        deck.shuffle();


        gui.promptPlayerName();
        participants.add(new Player(input.readString()));

        participants.add(new Dealer("Dealer")); // dealer is always last


        while (playing) {
            playRound();
            gui.keepPlaying();

            if (input.readInt(2) == 2) {
                playing = false;
            }
        }


    }

    public void playRound() {
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

                if (p instanceof Dealer && round == 1) {
                    card.setHidden(true);
                }

                p.getHand().addCard(card);
            }
        }

        for (Participant p : participants) {
            displayParticipantHand(p);
        }

        for (Participant p : participants) {
            if (p instanceof Player player) {
                player.playTurn(deck, rules);

            } else if (p instanceof Dealer dealer) {
                dealer.playTurn(deck, rules);
            }
        }

        resolveWinner();
    }

    public void resolveWinner() {
        Participant dealer = participants.getLast(); // dealer is always last

        for (Card card : dealer.getHand().getCards()) {
            card.setHidden(false);
        }
        displayParticipantHand(dealer);

        int dealerScore = dealer.getHand().getScore();
        boolean dealerBusted = dealer.getHand().isBusted();

        for (Participant p : participants) {
            if (!p.isDealer()) {
                int playerScore = p.getHand().getScore();
                boolean playerBusted = p.getHand().isBusted();


                gui.declareWinner(playerScore, playerBusted, dealerScore, dealerBusted, p.getName());
            }
        }
    }
}
