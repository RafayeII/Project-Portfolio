package managers;

import core.*;
import core.weapontype.Ranged;
import others.ResourceChecker;

public class HoneManager {

	public void honeWeapon(Weapon w, Resource r, int count) {
		ResourceChecker rchecker = new ResourceChecker();
		Ranged temp = (Ranged) w;
			
		if (rchecker.isResourceSufficient(count * 10, r)) {
			if (temp.getCritDamage() != 2) {
				for (int i = 1; i <= count; i++) 
					if (temp.getCritDamage() < 2) {
						temp.hone();
						r.decreaseAmount(10);
					}
				System.out.printf("\n%s's Crit Dmg is increased to %.0f%%!\n", temp.getName(), (temp.getCritDamage() * 100));
			}
			
			else
				System.out.println("\nError Honing: Crit DMG Already Maxed!");
		}
		
		
		else
			System.out.println("\nError Honing: Not Enough Resources!");
	}
}
