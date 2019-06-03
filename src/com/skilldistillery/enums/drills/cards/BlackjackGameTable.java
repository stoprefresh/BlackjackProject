package com.skilldistillery.enums.drills.cards;

import java.util.*;

public class BlackjackGameTable {

	private List<Hand> players;
	private String selection;
	private boolean gameRun, continuePlay, roundEnd;
	private Player user;
	private Dealer theHouse;
	private Deck newDeck;
	private BlackjackRulesEngine bjRules;

	// This will be where the game is run from. All methods for decision making and
	// game logic will be implemented here.
	public void gameStart() {

		Scanner sc = new Scanner(System.in);
		user = new Player();
		theHouse = new Dealer();
		newDeck = new Deck();
		gameRun = true;
		roundEnd = true;
		players = new ArrayList<Hand>();
		players.add(user);
		players.add(theHouse);

		bjRules = new BlackjackRulesEngine();

		System.out.println("Welcome to the BlackJack Table!");
		System.out.println("_______________________________");
		System.out.println();
		System.out.println();
		while (gameRun == true) {
			playKeepPlay(sc);

			if (gameRun == true) {
				if (newDeck.checkDeckSize() == true) {
					startingHand();
					if (roundEnd == true) {
						turnsAndRounds(sc);
						if (roundEnd == true) {
							dealerTurn();
							bjRules.finalCheck(user, theHouse);
							System.out.println("The House: ");
							theHouse.getCards();
							System.out.println("\n The Player: ");
							user.getCards();
						}
					} else {
						bjRules.finalCheck(user, theHouse);
						diplayTable();
					}
				} else if (newDeck.checkDeckSize() != true) {
					newDeck = new Deck();
					newDeck.shuffleDeck();
				}
			}
		}
	}

	// This method will resest the hand at the beginning of each round unless the
	// player does not with to play anymore.
	// A later feeature will prompt the user for their name.
	// This method will also seek to mimic how turns ran.
	private void startingHand() {
		System.out.println("\nLets start by dealing your hand....\n");

		user.setTotalBlackJackVal();
		theHouse.setTotalBlackJackVal();

		user.clearHand();
		theHouse.clearHand();
		newDeck.shuffleDeck();
		System.out.println("'User' first card");
		user.addCard(newDeck.dealCard());
		System.out.println("House's first card");
		theHouse.addCard(newDeck.dealCard());
		System.out.println("'User' second card");
		user.addCard(newDeck.dealCard());
		System.out.println("House's second card");
		theHouse.addCard(newDeck.dealCard());

		roundEnd = bjRules.intitalHandCheck(players);
	}

	// This method will determine if the game will start and if a player wants to
	// continue.
	private boolean playKeepPlay(Scanner sc) {
		System.out.println("\nPlay a round?");
		System.out.println("-------------");
		System.out.println("1. yes");
		System.out.println("2. no");
		selection = sc.nextLine();
		switch (selection) {

		case "1":
			System.out.println("\nLets not waste anytime then.\n");

			gameRun = true;
			break;
		case "2":
			System.out.println("\nMaybe next time...\n");
			gameRun = false;
			break;
		default:
			System.out.println("\nThat's not something I understand....\n");
			break;

		}
		return gameRun;
	}

	// This method will be the focus of each individual round. It will be provide
	// the user with options and decisions to affect gameplay on their turn.
	// This method will be ran for both the user only.
	private boolean turnsAndRounds(Scanner sc) {

		continuePlay = false;

		do {
			diplayTable();
			user.gameMenus();
			selection = user.decisionBJ(sc);

			switch (selection) {

			case "1":
				System.out.println(user.getClass().getSimpleName() + "Decides to Hit\n");
				user.addCard(newDeck.dealCard());
				continuePlay = bjRules.inGameHandCheck(user.getHandValueBJ());
				roundEnd = continuePlay;
				break;

			case "2":
				continuePlay = false;
				System.out.println(user.getClass().getSimpleName() + " Decides to Stay\n");
				break;

			case "3":
				continuePlay = false;
				gameRun = false;
				System.out.println(user.getClass().getSimpleName() + " Decides to Leave");
				break;

			default:
				System.out.println("Do you understand how to play?");
				break;
			}
		} while (continuePlay == true);

		return gameRun;
	}

	// This method is for the dealers turn.
	private boolean dealerTurn() {

		continuePlay = false;

		System.out.println("The house turns and displays...");
		theHouse.getCards();
		System.out.println();
		do {

			selection = theHouse.dDealer();

			switch (selection) {

			case "1":
				System.out.println("\nThe Dealer turns another...");
				theHouse.addCard(newDeck.dealCard());
				theHouse.getCards();
				System.out.println(theHouse.getHandValueBJ());
				continuePlay = bjRules.inGameHandCheck(theHouse.getHandValueBJ());
				break;
			case "2":
				System.out.println("\nThe dealer stays at " + theHouse.getHandValueBJ());
				continuePlay = false;
				break;
			default:

				break;
			}
		} while (continuePlay == true);
		return gameRun;
	}

	// This method will display the table as play progresses.
	private void diplayTable() {
		System.out.println("\n____________________________");
		System.out.println("The house shows: ");
		theHouse.showCard();
		System.out.println();
		System.out.println("\nYour hand is as follows: " + user.getHandValueBJ());
		user.getCards();
		System.out.println("____________________________\n");
	}
}
