package core.charactertype;

import core.Character;

public class BladedCharacter extends Character {
	
	public BladedCharacter(int random) {
		//RARITY 1
			if (random >= 1 && random <= 10) {
		        this.name = "Jekyll";
		        this.rarity = 1;
		        this.element = "Joker";
			}
			
			else if (random >= 11 && random <= 20) {
		        this.name = "Stede";
		        this.rarity = 1;
		        this.element = "Cyclone";
			}
		
		//RARITY 2
			else if (random >= 21 && random <= 27) {
		        this.name = "Bonney";
		        this.rarity = 2;
		        this.element = "Trigger";
			}
			
			else if (random >= 28 && random <= 34) {
		        this.name = "Jeanne";
		        this.rarity = 2;
		        this.element = "Luna";
			}
		
		//RARITY 3
			else if (random >= 35 && random <= 37) {
		        this.name = "Masamune";
		        this.rarity = 3;
		        this.element = "Metal";
			}
			
			else if (random >= 38 && random <= 40) {
		        this.name = "Hermes";
		        this.rarity = 3;
		        this.element = "Heat";
			}
		
		this.level = 20;
	}
	
	@Override
	public String getType() {
		return "Bladed";
	}
	
}
