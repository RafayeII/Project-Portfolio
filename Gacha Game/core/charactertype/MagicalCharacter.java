package core.charactertype;

import core.Character;

public class MagicalCharacter extends Character{

	public MagicalCharacter(int random) {
		//RARITY 1
			if (random >= 1 && random <= 10) { 
		        this.name = "Count d'Artagnan";
		        this.rarity = 1;
		        this.element = "Metal";
			}
			
			else if (random >= 11 && random <= 20) {
		        this.name = "Val Helmont";
		        this.rarity = 1;
		        this.element = "Heat";
			}
			
		//RARITY 2
			else if (random >= 21 && random <= 27) {
		        this.name = "Gray";
		        this.rarity = 2;
		        this.element = "Joker";
			}
		
			else if (random >= 28 && random <= 34) {
		        this.name = "Teach";
		        this.rarity = 2;
		        this.element = "Cyclone";
			}
			
		//RARITY 3	
			else if (random >= 35 && random <= 37) {
		        this.name = "Clyde";
		        this.rarity = 3;
		        this.element = "Trigger";
			}
			
			else if (random >= 38 && random <= 40) {
		        this.name = "Arthur";
		        this.rarity = 3;
		        this.element = "Luna";
			}
		
		this.level = 20;
	}
	
	@Override
	public String getType() {
		return "Magical";
	}
	
}
