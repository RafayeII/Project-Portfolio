package core.weapontype;

import core.Weapon;

public class Ranged extends Weapon{
	private float critdamage;
	
	public Ranged(int random) {
		//RARITY 1
			if (random >= 1 && random <= 15) {
		        this.name = "Revolver";
		        this.rarity = 1;
		        this.power = 150;
			}
			
			else if (random >= 16 && random <= 30) {
		        this.name = "English Longbow";
		        this.rarity = 1;
		        this.power = 180;
			}
			
		//RARITY 2
			else if (random >= 31 && random <= 51) {
		        this.name = "Bashosen";
		        this.rarity = 2;
		        this.power = 190;
			}
			
		//RARITY 3
			else if (random >= 52 && random <= 60) {
		        this.name = "Fragarach";
		        this.rarity = 3;
		        this.power = 200;
			}
		
		this.level = 1;
		this.critdamage = 1;
	    this.owned = false;
	}
	
	@Override
	public String getType() {
		return "Ranged";
	}
	
	public void hone() {
		if (this.critdamage < 2)
			this.critdamage += 0.2;
	}
	
	
	@Override
	public int getPower() {
		return (int)(this.power * this.critdamage);
	}
	
	public float getCritDamage() {
		return this.critdamage;
	}

}
