package com.skilldistillery.enums.drills.cards;

public class BlackjackApp {
	
		// The main calls and starts the game from the the BlackjackTable
		// class to drive the game
		public static void main(String[] args) {
			BlackjackGameTable gd = new BlackjackGameTable();
			gd.gameStart();
		}	
}
