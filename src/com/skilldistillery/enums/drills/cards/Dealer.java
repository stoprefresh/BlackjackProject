package com.skilldistillery.enums.drills.cards;

import java.util.Scanner;

public class Dealer extends Hand {

	
	public Dealer(){}
	
	
	
	
	public String decisionBJ(Scanner sc) {
		
		if(getHandValueBJ() < 17) {
			decisions = "1";
		}
		else if(getHandValueBJ() >= 17) {
			decisions = "2";
		}
		
		return decisions;
	}
	
	public void showCard(){

		System.out.println(hand.get(0));
	}

}
