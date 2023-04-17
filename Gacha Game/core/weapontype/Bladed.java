package core.weapontype;

import core.Weapon;

public class Bladed extends Weapon{
	
	public Bladed() {}
	
	public Bladed(int random) {
		//RARITY 1
			if (random >= 1 && random <= 10) {
		        this.name = "Knife";
		        this.rarity = 1;
		        this.power = 130;
			}
			
			else if (random >= 11 && random <= 20) {
		        this.name = "Rapier";
		        this.rarity = 1;
		        this.power = 140;
			}
			
			else if (random >= 21 && random <= 30) {
		        this.name = "Clarent";
		        this.rarity = 1;
		        this.power = 170;
			}
		
		//RARITY 2
			else if (random >= 31 && random <= 51) {
		        this.name = "Five-cross Sword";
		        this.rarity = 2;
		        this.power = 180;
			}
			
		//RARITY 3
			else if (random >= 52 && random <= 54) {
		        this.name = "Fragarach";
		        this.rarity = 3;
		        this.power = 200;
			}
			
			else if (random >= 55 && random <= 57) {
		        this.name = "Honjo Masamune";
		        this.rarity = 3;
		        this.power = 210;
			}
			
			else if (random >= 58 && random <= 60) {
		        this.name = "Excalibur";
		        this.rarity = 3;
		        this.power = 220;
			}
			
		this.level = 1;
	    this.owned = false;
	}
	
	@Override
	public String getType() {
		return "Bladed";
	}
	
	@Override
	public int getPower() {
		return this.power + (10 * this.rarity);
	}

}
