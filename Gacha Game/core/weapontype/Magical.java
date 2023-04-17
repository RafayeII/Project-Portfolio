package core.weapontype;

import core.Weapon;

public class Magical extends Weapon {

	public Magical (int random) {
		//RARITY 1
			if (random >= 1 && random <= 30) {
		        this.name = "Mermaid Tears";
		        this.rarity = 1;
		        this.power = 160;
			}

		//RARITY 2
			else if (random >= 31 && random <= 37) {
		        this.name = "Circe Staff";
		        this.rarity = 2;
		        this.power = 150;
			}
			
			else if (random >= 38 && random <= 44) {
		        this.name = "Vorpal Sword";
		        this.rarity = 2;
		        this.power = 160;
			}
		
			else if (random >= 45 && random <= 51) {
		        this.name = "Merlin's Staff";
		        this.rarity = 2;
		        this.power = 170;
			}
		
		//RARITY 3
			else if (random >= 52 && random <= 60) {
		        this.name = "Philosopher's Stone";
		        this.rarity = 3;
		        this.power = 180;
			}
		
		this.level = 1;
	    this.owned = false;
	}
	
	@Override
	public String getType() {
		return "Magical";
	}
	
	@Override
	public int getRarity() {
		return this.rarity + 1;
	}
	
}
