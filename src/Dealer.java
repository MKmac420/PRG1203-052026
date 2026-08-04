public class Dealer extends Participant {
// constructor
    public Dealer(String name) {
        super(name);
    }

    @Override
    public boolean isDealer() {
    	// is a dealer, return true
        return true;
    }

    @Override
    public void playTurn(Deck deck, HouseRules rules) {
    	// flip the hidden card
        for (Card card : getHand().getCards()) {
            card.setHidden(false);
        }

        System.out.printf("\n--- %s's Turn ---\n", getName());
        // Loop until the hand is busted
        while (!getHand().isBusted()) {
            int score = getHand().getScore();

            // if over 17, stop the loop
            if (score > 17) {
                stand();
                System.out.printf("%s stands with score %d.\n", getName(), score);
                break;
            } else if (score == 17) {
                // If the soft 17 rule is enabled, hit. if not stand.
                if (getHand().isSoft() && rules.isHitSoft17()) {
                    System.out.printf("%s hits.\n", getName());
                    hit(deck);
                } else {
                    stand();
                    System.out.printf("%s stands with score 17.\n", getName());
                    break;
                }
            } else {
            	// if less than 16, hit.
                System.out.printf("%s hits.\n", getName());
                hit(deck);
            }

            // Checking if busted
            if (getHand().isBusted()) {
                System.out.printf("%s busted with score %d!\n", getName(), getHand().getScore());
                break;
            }
        }
    }
}
