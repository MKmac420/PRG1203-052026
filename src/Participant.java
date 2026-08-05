public class Participant {
	protected String name;
    protected Hand hand;
    protected boolean isStanding;
    
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
	
	public void reset() {
		hand.clear();
		isStanding = false;
	}
    
    
    
}
