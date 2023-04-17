package core.charactertype;

import core.Character;

public class RangedCharacter extends Character {
	
	public RangedCharacter(int random) {
		//RARITY 1
			if (random >= 1 && random <= 10) {
		        this.name = "Earl Robert";
		        this.rarity = 1;
		        this.element = "Trigger";
			}
			
			else if (random >= 11 && random <= 20) {
		        this.name = "Kaguya";
		        this.rarity = 1;
		        this.element = "Luna";
			}
		
		//RARITY 2
			else if (random >= 21 && random <= 27) {
		        this.name = "Sir William Marshal";
		        this.rarity = 2;
		        this.element = "Metal";
			}
			
			else if (random >= 28 && random <= 34) {
		        this.name = "Paracelsus";
		        this.rarity = 2;
		        this.element = "Heat";
			}
		
		//RARITY 3
			else if (random >= 35 && random <= 37) {
		        this.name = "Faust";
		        this.rarity = 3;
		        this.element = "Joker";
			}
			
			else if (random >= 38 && random <= 40) {
		        this.name = "Avery";
		        this.rarity = 3;
		        this.element = "Cyclone";
			}
		
		this.level = 20;
	}
	
	@Override
	public String getType() {
		return "Ranged";
	}
	
}
