package com.skilldistillery.enums.drills.cards;

public enum Suit {

	HEARTS("Hearts"),
	SPADES("Spades"), 
	CLUBS("Clubs"), 
	DIAMONDS("Diamonds");
	
	
	private String cardName;
	
	Suit(String cardName) {
		
		this.cardName = cardName;
		
	}
	
	public String toString() {
		return cardName;
	}
	
}
