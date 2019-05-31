package com.skilldistillery.enums.drills.cards;

import java.util.*;

public class Deck {

	private List<Card> deckCards;

	public Deck() {
		deckCards = new ArrayList<Card>();
		
		Rank[] ranks = Rank.values();
		
		for(int i = 0; i < 13; i++) {
			deckCards.add(new Card(ranks[i], Suit.CLUBS));
		}
		for(int i = 0; i < 13; i++) {
			deckCards.add(new Card(ranks[i], Suit.SPADES));
		}
		for(int i = 0; i < 13; i++) {
			deckCards.add(new Card(ranks[i], Suit.DIAMONDS));
		}
		for(int i = 0; i < 13; i++) {
			deckCards.add(new Card(ranks[i], Suit.HEARTS));
		}
	}
	
	public boolean checkDeckSize() {
		
		if(deckCards.size() == 52) {
			System.out.println("The deck has " + deckCards.size() + " cards and is ready to use.");
			return true;
		}
		else if ((deckCards.size() < 52) && (deckCards.size() > 0)){
			System.out.println("The deck does not have 52 cards. It is currently at " + deckCards.size());
			return true;
		}
		else {
			System.out.println("The Deck needs to be reshuffled before a hand can be dealt.");
			return false;
		}
	}
	
	public Card dealCard() {
				
		return deckCards.remove(0);
	
	}
	
	public void shuffleDeck() {
		Collections.shuffle(deckCards);
	}
}
