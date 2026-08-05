import java.util.ArrayList;
import java.util.List;

public class Hand {
	private List<Card> cards;

	public Hand() {
		cards = new ArrayList<>();
	}

	public void addCard(Card card) {
		cards.add(card);
	}

	public void clear() {
		cards.clear();
	}

	public List<Card> getCards() {
		return cards;
	}

	public int getScore() {
		int score = 0;
		int aceCount = 0;

		for (Card card : cards) {
			score += card.getValue();

			if (card.getRank().equals("Ace")) {
				aceCount++;
			}
		}

		// Convert Aces from 11 to 1 if necessary
		while (score > 21 && aceCount > 0) {
			score -= 10;
			aceCount--;
		}

		return score;
	}

	public boolean isSoft() {
		int score = 0;
		int aceCount = 0;

		for (Card card : cards) {
			score += card.getValue();

			if (card.getRank().equals("Ace")) {
				aceCount++;
			}
		}

		while (score > 21 && aceCount > 0) {
			score -= 10;
			aceCount--;
		}

		return aceCount > 0;
	}

	public boolean isBusted() {
		return getScore() > 21;
	}
}
