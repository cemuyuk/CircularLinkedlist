
public class Card {
	//S=1, H=2, C=3, D=4
	private int suit;
	private int rank;
	private Card next;
	private Card previous;
	
	public Card(String suit, int rank){
		if(suit.equals("S"))
			this.suit=1;
		else if(suit.equals("H"))
			this.suit=2;
		else if(suit.equals("C"))
			this.suit=3;
		else if(suit.equals("D"))
			this.suit=4;
		this.rank=rank;
	}

	public int getSuit() {
		return suit;
	}

	public void setSuit(int suit) {
		this.suit = suit;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public Card getNext() {
		return next;
	}

	public void setNext(Card next) {
		this.next = next;
	}

	public Card getPrevious() {
		return previous;
	}

	public void setPrevious(Card prev) {
		this.previous = prev;
	}
	
	
}
