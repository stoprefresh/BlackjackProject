package com.skilldistillery.enums.drills.cards;

import java.util.*;

public class BlackjackGameTable {

	private int selection;
	private boolean gameRun;
	private Player user;
	private Dealer theHouse;
	private Deck newDeck;

	
	// This will be where the game is run from. All methods for decision making and game logic
	// will be implemented here. 
	public void gameStart() {
		
		Scanner sc = new Scanner(System.in);
		user = new Player();
		theHouse = new Dealer();
		newDeck = new Deck();
		gameRun = true;

		System.out.println("Welcome to the BlackJack Table!");
		System.out.println("_______________________________");
		System.out.println();
		System.out.println();
		System.out.println("Let's not waste anytime, you're here so lets play.\n");
		System.out.println("I'll start by shuffling the Deck.\n");
	    newDeck.shuffleDeck();

		while (gameRun == true) {
			
			if(newDeck.checkDeckSize() == true) {
				startingHand();
				
				turnsAndRounds(sc);
				
			}
			else if (newDeck.checkDeckSize() != true){
				newDeck = new Deck();
				
				newDeck.shuffleDeck();
			}
			
		}
	}
	
	// This method will resest the hand at the beginning of each hand unless the player does
	// not with to play anymore. A later feeature will prompt the user for their name.
	// This method will also seek to mimic how turns ran.
	private void startingHand() {
		System.out.println("We will begin play by dealing your opening hand....\n");
		
		user.clearHand();
		theHouse.clearHand();
		
		System.out.println("'User' first card\n");
		user.addCard(newDeck.dealCard());
		System.out.println("House's first card\n");
		theHouse.addCard(newDeck.dealCard());
		System.out.println("'User' second card\n");
		user.addCard(newDeck.dealCard());
		System.out.println("House's second card\n");
		theHouse.addCard(newDeck.dealCard());
		
	}
	// This method will be the focus of each individual round. It will be provide the user with
	// options and decisions to affect gameplay on their turn.
	private boolean turnsAndRounds(Scanner sc) {
		
		boolean selectionValid = false;
	
		
			do {
				gameMenus();
				try {
					selection = sc.nextInt();
					selectionValid = true;
				} catch (InputMismatchException e) {
					sc.nextLine();
					
				}
				
				switch (selection) {

				case 1:
					System.out.println("The House has the follwing face-up.");
					theHouse.showCard(); 
					System.out.println("\nYour cards are as follows.");
					user.getCards();
					System.out.println();
					break;
				case 2:
					System.out.println("Here's another.....");
					user.addCard(newDeck.dealCard());
					break;
				case 3:
					System.out.println("Turn moves to the House.");
					selectionValid = false;
					break;
				case 4:
					System.out.println("That it huh?");
					gameRun = false;
					selectionValid = false;
					break;
				default:
		            selectionValid = false;
					break;
				}
			} while (selectionValid == true);
		
		return gameRun;
	}
	
	// The game menu will be called to give the player options on their turn and used in 
	// the turns and rounds method.
	private void gameMenus() {
		System.out.println();
		System.out.println();
		System.out.println("What would you like to do?");
		System.out.println("==========================");
		System.out.println("1. View Hand and Dealers Face-up\t");
		System.out.println("2. Hit\t");
		System.out.println("3. Stay\t");
		System.out.println("4. Leave the table and your money\t\n");
		
	}
	
	private void houseRules() {

	}

}
