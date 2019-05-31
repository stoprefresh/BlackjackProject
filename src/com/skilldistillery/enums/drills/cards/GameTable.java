package com.skilldistillery.enums.drills.cards;

import java.util.*;

public class GameTable {

	private int numberOfCards, selection;
	private boolean gameRun;

	void gameStart() {

		System.out.println("Welcome to BlackJack!");
		Scanner sc = new Scanner(System.in);
		Player user = new Player();
		Dealer theHouse = new Dealer();
		Deck newDeck = new Deck();
		gameRun = true;

		while (gameRun = true) {

			turnsAndRounds(sc);

		}

		System.out.println("How many cards would you like?");

		try {
			numberOfCards = sc.nextInt();

			if ((numberOfCards > 52) || (numberOfCards < 0)) {
				System.out.println("That is an invalid entry.");
			}
		} catch (InputMismatchException e) {
			System.out.println("You must enter a integer.");
		}

		System.out.println(newDeck.checkDeckSize());
		newDeck.shuffleDeck();

		System.out.println("Dealing Card(s)....");

		for (int i = 0; i < numberOfCards; i++) {
			user.addCard(newDeck.dealCard());

		}
		user.getCards();

		System.out.println(newDeck.checkDeckSize());

		sc.close();
	}

	public void turnsAndRounds(Scanner sc) {

		boolean selectionValid = false;

		try {
			selection = sc.nextInt();
			selectionValid = true;

			do {
				switch (selection) {

				case 1:

					break;
				case 2:

					break;
				case 3:

					break;
				case 4:

					break;
				case 0:

					break;
				default:
					selectionValid = false;
					break;
				}
			} while (selectionValid == true);
		} catch (InputMismatchException e) {
			System.out.println("You must enter a integer.");
		}

	}

	public void houseRules() {

	}

}
