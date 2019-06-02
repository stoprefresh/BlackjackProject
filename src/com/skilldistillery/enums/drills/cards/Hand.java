package com.skilldistillery.enums.drills.cards;

import java.util.*;

public abstract class Hand {

	protected String decisions;
	protected int totalBlackJackVal = 0;
	protected List<Card> hand;

	public Hand() {
		hand = new ArrayList<Card>();
	}
	
	protected abstract String decisionBJ(Scanner sc);

	protected int getHandValueBJ() {
		for(int i = 0; i < hand.size(); i++) {
			totalBlackJackVal += hand.get(i).getValue();	
		}
		return totalBlackJackVal;
	}

	protected void addCard(Card card) {
		hand.add(card);
	}

	protected void clearHand() {
		hand = new ArrayList<Card>();
	}

	protected List<Card> getCards() {

		if (hand.size() > 0) {
			for (int i = 0; i < hand.size(); i++) {
				System.out.println(hand.get(i).toString());
			}
		}
		else {
			System.out.println("Empty");	
		}
		return null;
	}

	@Override
	public String toString() {
		return "Hand [getHandValue()=" + getHandValueBJ() + ", getCards()=" + getCards() + "]";
	}

	public String getDecisions() {
		return decisions;
	}

	public void setDecisions(String decisions) {
		this.decisions = decisions;
	}

	public int getTotalBlackJackVal() {
		return totalBlackJackVal;
	}

	public void setTotalBlackJackVal(int totalBlackJackVal) {
		this.totalBlackJackVal = totalBlackJackVal;
	}

	public List<Card> getHand() {
		return hand;
	}

	public void setHand(List<Card> hand) {
		this.hand = hand;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((decisions == null) ? 0 : decisions.hashCode());
		result = prime * result + ((hand == null) ? 0 : hand.hashCode());
		result = prime * result + totalBlackJackVal;
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
		Hand other = (Hand) obj;
		if (decisions == null) {
			if (other.decisions != null)
				return false;
		} else if (!decisions.equals(other.decisions))
			return false;
		if (hand == null) {
			if (other.hand != null)
				return false;
		} else if (!hand.equals(other.hand))
			return false;
		if (totalBlackJackVal != other.totalBlackJackVal)
			return false;
		return true;
	}





}
