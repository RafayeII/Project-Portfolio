package core.weapontype;

import core.Inventory;
import core.GachaMachine;

public class Golden extends Bladed{

	public Golden (int random) {

		//RARITY 2
			if (random >= 1 && random <= 36) {
		        this.name = "Golden Cudgel";
		        this.rarity = 2;
		        this.power = 200;
			}
		
		//RARITY 3
			else if (random >= 36 && random <= 60) {
		        this.name = "Scythe of Father Time";
		        this.rarity = 3;
		        this.power = 230;
			}
			
		this.level = 1;
	    this.owned = false;	
	}
	
	
	@Override
	public String getType() {
		return "Golden";
	}
	
	public void reroll(Inventory i) {
		GachaMachine reroll = new GachaMachine();
		i.disposeWeapon(this);
		i.storeWeapon(reroll.singleWeaponPull(i.getResource(), 150));
	}
}
