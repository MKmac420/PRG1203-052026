public class Participant {
	protected String name;
    protected Hand hand;
    protected boolean isStanding;
    protected boolean isDealer;
    
    public Participant(String name ) {
    	this.name = name;
    	this.hand = new Hand();
    	this.isStanding = false;
    	}

	public String getName() {
		return name;
	}

	public Hand getHand() {
		return hand;
	}


	public boolean isStanding() {
		return isStanding;
	}

	public void setStanding(boolean isStanding) {
		this.isStanding = isStanding;
	}
	
	public boolean isDealer() {
		return isDealer;
	}

	public void setDealer(boolean isDealer) {
		this.isDealer = isDealer;
	}
	
	public void playTurn(Deck Deck, HouseRules HouseRules) {
		
	}

	public void reset() {
		hand.clear();
		isStanding = false;
	}
    
    
    
}
