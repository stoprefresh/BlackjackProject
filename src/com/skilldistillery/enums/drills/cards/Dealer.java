package com.skilldistillery.enums.drills.cards;

public class Dealer extends Hand {

	public Dealer(){}
	
	public String dDealer() {
		
		
		if(getHandValueBJ() < 17) {
			decisions = "1";
		}
		else if(getHandValueBJ() >= 17) {
			decisions = "2";
		}
		else {
			decisions = "2";
		}
		return decisions;
	}
	
	public void showCard(){
		System.out.println(hand.get(0));
	}
	

	@Override
	protected void gameMenus() {
		
	}
}
