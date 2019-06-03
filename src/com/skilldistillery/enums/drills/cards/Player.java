package com.skilldistillery.enums.drills.cards;

import java.util.*;

public class Player extends Hand{

	public Player(){}
	
	// Method called for player decisions to check if input is valid.
	protected String decisionBJ(Scanner sc) {
		
		try {
			decisions = sc.nextLine();
			
		} catch (InputMismatchException e) {
			System.out.println("Input invalid, try again.");
		}
		return decisions;
	}
	
	// The game menu will be called to give the player options on their turn and used in 
		// the turns and rounds method.
	protected void gameMenus() {
		System.out.println();
		System.out.println();
		System.out.println("What would you like to do?");
		System.out.println("==========================");
		System.out.println("1. Hit\t");
		System.out.println("2. Stay\t");
		System.out.println("3. Fold, Leave the table and your money\t\n");
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		return true;
	}
}
