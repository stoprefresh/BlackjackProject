package com.skilldistillery.enums.drills.cards;

import java.util.*;

public class BlackjackGameTable {

	private List<Hand> players;
	private String selection;
	private boolean gameRun;
	private Player user;
	private Dealer theHouse;
	private Deck newDeck;
	private BlackjackRulesEngine bjRules;

	// This will be where the game is run from. All methods for decision making and
	// game logic
	// will be implemented here.
	public void gameStart() {

		Scanner sc = new Scanner(System.in);
		user = new Player();
		theHouse = new Dealer();
		newDeck = new Deck();
		gameRun = true;
		players = new ArrayList<Hand>();
		players.add(user);
		players.add(theHouse);

		bjRules = new BlackjackRulesEngine();

		System.out.println("Welcome to the BlackJack Table!");
		System.out.println("_______________________________");
		System.out.println();
		System.out.println();
		System.out.println("Let's not waste anytime, you're here, so lets play.\n");
		System.out.println("I'll start by shuffling the Deck.\n");
		
		
		while (gameRun == true) {
			playKeepPlay(sc);
			
			if (newDeck.checkDeckSize() == true) {
				startingHand();
				turnsAndRounds(players, sc);

			} else if (newDeck.checkDeckSize() != true) {
				newDeck = new Deck();
				newDeck.shuffleDeck();
			}
		}
	}
	
	 

	// This method will resest the hand at the beginning of each hand unless the
	// player does
	// not with to play anymore. A later feeature will prompt the user for their
	// name.
	// This method will also seek to mimic how turns ran.
	private void startingHand() {
		System.out.println("Lets start by dealing your hand....\n");

		user.clearHand();
		theHouse.clearHand();
		newDeck.shuffleDeck();
		System.out.println("'User' first card\n");
		user.addCard(newDeck.dealCard());
		System.out.println("House's first card\n");
		theHouse.addCard(newDeck.dealCard());
		System.out.println("'User' second card\n");
		user.addCard(newDeck.dealCard());
		System.out.println("House's second card\n");
		theHouse.addCard(newDeck.dealCard());
		gameRun = bjRules.intitalHandCheck(players);

	}
	
	private boolean playKeepPlay(Scanner sc) {
		System.out.println("Play a round?");
		System.out.println("-------------");
		System.out.println("1. yes");
		System.out.println("2. no");
		selection = user.decisionBJ(sc);
		switch(selection) {
		
		case "1":
			System.out.println("Lets not waste anytime then.");
			gameRun = true;
			break;
		case "2":
			System.out.println("Maybe next time...");
			gameRun = false;
			break;
		default:
			System.out.println("Thats not something I understand....");
			break;
		
		}
		return gameRun;
	}
	
	
	
	// This method will be the focus of each individual round. It will be provide
	// the user with options and decisions to affect gameplay on their turn.
	// This method will be ran for both the User(s) and dealer.
	private boolean turnsAndRounds(List<Hand> players, Scanner sc) {

		boolean continuePlay = false;

		for (Hand cur : players) {
			
			do {
				diplayTable();
				selection = cur.decisionBJ(sc);
				
				switch (selection) {

				case "1":
					System.out.println("Hit");
					cur.addCard(newDeck.dealCard());
					continuePlay = bjRules.inGameHandCheck(cur.getHandValueBJ());
					break;
					
				case "2":
					continuePlay = false;
					System.out.println("Stay");
					break;
					
				case "3":
					continuePlay = false;
					gameRun = false;
					System.out.println("Leave");
					break;
					
				default:
					System.out.println("Do you understand how to play?");
					break;
				}
			} while (continuePlay == true);

		}
		return gameRun;
	}

	
	// This method will display the table as play progresses.
	private void diplayTable() {
		System.out.println("The house shows :");
		theHouse.showCard();
		System.out.println("Your hand is as follows: ");
		user.getCards();
		
	}
}
