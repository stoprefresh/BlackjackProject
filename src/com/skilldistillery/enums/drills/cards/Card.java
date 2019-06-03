package com.skilldistillery.enums.drills.cards;

public class Card {

	private int value;
	
	private Rank cardCurRank;
	
	private Suit cardCurSuit;
	
	Card(){}
	
	Card(Rank r, Suit s){
		this.cardCurRank = r;
		this.cardCurSuit = s;
		this.value = r.getValue();
	}
	
	public int getValue() {
		return value;
	}
	
	@Override
	public String toString() {
		return cardCurRank + " of " + cardCurSuit + " [Worth: " + value + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cardCurRank == null) ? 0 : cardCurRank.hashCode());
		result = prime * result + ((cardCurSuit == null) ? 0 : cardCurSuit.hashCode());
		result = prime * result + value;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Card other = (Card) obj;
		if (cardCurRank != other.cardCurRank)
			return false;
		if (cardCurSuit != other.cardCurSuit)
			return false;
		if (value != other.value)
			return false;
		return true;
	}

	public Rank getCardCurRank() {
		return cardCurRank;
	}

	public void setCardCurRank(Rank cardCurRank) {
		this.cardCurRank = cardCurRank;
	}

	public Suit getCardCurSuit() {
		return cardCurSuit;
	}

	public void setCardCurSuit(Suit cardCurSuit) {
		this.cardCurSuit = cardCurSuit;
	}
	
}
