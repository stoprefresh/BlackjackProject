package com.skilldistillery.enums.drills.cards;

import java.util.List;

public class BlackjackRulesEngine {

	private boolean gamePlayOn;

	BlackjackRulesEngine() {
	}

	// This rule will check each hand to see if any
	// of the opening hands are a Blackjack (i.e. 21)
	protected boolean intitalHandCheck(List<Hand> players) {

		for (Hand cur : players) {

			if (cur.getTotalBlackJackVal() == 21) {
				System.out.println("We have a 21 for " + cur.getClass().getSimpleName());
				gamePlayOn = false;
			} else {
				gamePlayOn = true;
			}
		}
		return gamePlayOn;
	}

	// This method is the final check of the game to announce the winner.
	protected void finalCheck(Hand player, Hand dealer) {

		if ((player.getHandValueBJ() > dealer.getHandValueBJ()) && (player.getHandValueBJ() <= 21)) {
			System.out.println("The Player wins with " + player.getHandValueBJ() + "\n");
		} else if ((player.getHandValueBJ() < dealer.getHandValueBJ()) && (dealer.getHandValueBJ() <= 21)) {
			System.out.println("The House wins with " + dealer.getHandValueBJ() + "\n");
		} else if (player.getHandValueBJ() == dealer.getHandValueBJ()) {
			System.out.println("Its a tie, Push.\n");
		}
	}

	// During each turn, this method checks to determine if a seat at the table has
	// won, lost, or can play till the turn.
	protected boolean inGameHandCheck(int handVal) {

		if (handVal == 21) {
			System.out.println("That's 21, you win!");
			gamePlayOn = false;
		} else if (handVal > 21) {
			System.out.println("I'm sorry, you've busted.");
			System.out.println(handVal);
			gamePlayOn = false;
		} else if (handVal < 21) {
			System.out.println("Would you like to hit again?");
			gamePlayOn = true;
		}
		return gamePlayOn;
	}
}
