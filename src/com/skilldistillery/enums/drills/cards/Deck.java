package com.skilldistillery.enums.drills.cards;

import java.util.*;

public class Deck {

	private List<Card> deckCards;
	
	// If time permits I will adjust the deck construction so that 
	// two or three decks are generated at the the start of the game.
	// Similar to live tables.
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
		
		if((deckCards.size() == 52) && (deckCards.size() > 6)) {
			System.out.println("The deck has is ready to use.\n");
			return true;
		}
		else if ((deckCards.size() <= 6)){
			System.out.println("The Deck is currently at " + deckCards.size() + " and needs to be shuffled before play can continue.\n");
			return false;
		}
		return false;
	}
	
	public Card dealCard() {
		return deckCards.remove(0);
	}
	
	public void shuffleDeck() {
		Collections.shuffle(deckCards);
	}
}
