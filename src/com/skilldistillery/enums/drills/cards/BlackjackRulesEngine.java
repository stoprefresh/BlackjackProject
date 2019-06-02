package com.skilldistillery.enums.drills.cards;

import java.util.List;

public class BlackjackRulesEngine {

	private boolean gamePlayOn;

	BlackjackRulesEngine() {
	}

	protected boolean houseRules(int handVal) {

		return gamePlayOn;
	}

	// This rule will check each hand to see if any
	// of the opening hands are a Blackjack (i.e. 21)
	protected boolean intitalHandCheck(List<Hand> players) {

		for (Hand cur : players) {

			if (cur.getHandValueBJ() == 21) {
				System.out.println("We have a 21 for " + cur.getClass().getSimpleName());
				gamePlayOn = false;
			} else {
				gamePlayOn = true;
			}
		}
		return gamePlayOn;
	}

	protected boolean inGameHandCheck(int handVal) {

		if(handVal == 21) {
			System.out.println("That's 21, you win!");
			gamePlayOn = false;
		}
		else if(handVal > 21) {
			System.out.println("I'm sorry, you've busted.");
			gamePlayOn = false;
		}
		else if(handVal < 21) {
			System.out.println("Would you like to hit again?");
			gamePlayOn = true;
		}
		
		
		return gamePlayOn;
	}
}
