package managers;

import core.*;
import core.weapontype.Golden;

public class RerollManager {
	
	public void rerollWeapon(Weapon w, Inventory i) {
		Golden temp = (Golden) w;
		if (!temp.getOwned()) 
			temp.reroll(i);
		
		else
			System.out.println("\nError Rerolling: Weapon is currently Equipped!");
	}
	
}
