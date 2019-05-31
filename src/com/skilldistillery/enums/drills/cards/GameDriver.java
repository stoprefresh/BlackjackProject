package com.skilldistillery.enums.drills.cards;

import java.util.*;

public class GameDriver {
	
	int numberOfCards;
	boolean gameRun;
	
	
	// This is where most of the game logic will go
//	Write a program to ask a user how many cards they want.
//
//	Handle the case where users enter a non-integer or 
//	a number greater than 52: print an error message.
//	Deal the cards and display them on the screen. 
//	Also display the total value of all cards
	void gameStart() {
		
		System.out.println("Welcome to BlackJack!");
		Scanner sc = new Scanner(System.in);
		BlackjackHand myHand = new BlackjackHand();
		Deck newDeck = new Deck();
		gameRun = true;
		
			
		System.out.println("How many cards would you like?");
		
		try {
			numberOfCards = sc.nextInt();
			
			if((numberOfCards > 52) || (numberOfCards < 0)) {
				System.out.println("That is an invalid entry.");
				System.out.println("Try again.");
			}
		}
		catch(InputMismatchException e) {
			System.out.println("You must enter a integer.");
		}
		
		System.out.println(newDeck.checkDeckSize());
		newDeck.shuffleDeck();
		
		System.out.println("Dealing Card(s)....");
		
		for(int i = 0; i < numberOfCards; i++) {
			myHand.addCard(newDeck.dealCard(i));
			
		}
		myHand.getCards();
		
		
		System.out.println(newDeck.checkDeckSize());
		
		
		
		
		
		
		
		
		
		sc.close();
	}
	
}
