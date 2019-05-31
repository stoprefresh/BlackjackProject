package com.skilldistillery.enums.drills.cards;

import java.util.*;

public class Hand {

	private List<Card> hand;

	Hand() {
		hand = new ArrayList<Card>();
	}

	public int getHandValue() {

		return 0;
	}

	public void addCard(Card card) {
		hand.add(card);
	}

	public void clearHand() {

	}

	public List<Card> getCards() {

		if (hand.size() > 0) {
			for (int i = 0; i < hand.size(); i++) {
				System.out.println(hand.get(i));
			}
		}

		return null;

	}

	@Override
	public String toString() {
		return "Hand [getHandValue()=" + getHandValue() + ", getCards()=" + getCards() + "]";
	}

}
