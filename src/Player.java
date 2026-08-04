public class Player extends Participant {
//constructor
    public Player(String name) {
        super(name);
    }
    
    @Override
    public boolean isDealer() {
    	// player is not a dealer, return false
        return false;
    }

    @Override
    public void playTurn(Deck deck, HouseRules rules) {
        // check whether player's hand is busted or in standing phase, create loop until action finished
        while (!hand.isBusted() && !isStanding()) {
            Input input = new Input();
            String action = promptAction(input);

            if ("1".equals(action)) { // Hit(value is 1)
                hit(deck);
                System.out.printf("%s hits.\n", getName());
                
                //Checking if busted
                if (hand.isBusted()) {
                    System.out.printf("%s busted!\n", getName());
                    break;
                }
            } else if ("2".equals(action)) { // Stand(value is 2)
                stand();
                System.out.printf("%s stands.\n", getName());
                break;
            }
        }
    }

    // Picking hit or stand
    private String promptAction(Input input) {
        System.out.println("\nChoose your action:");
        System.out.println("1. Hit");
        System.out.println("2. Stand");
        
        // Set the allowing input number between 1-2 by using input class
        int choice = input.readInt(2);
        return String.valueOf(choice);
    }
}
