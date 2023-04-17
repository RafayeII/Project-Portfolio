package managers;

import core.Character;
import core.charactertype.*;
import core.weapontype.*;
import core.Weapon;

public class EquipmentManager{

	  public void equip(Character c, Weapon w){

	    if (w.getOwned() == false && c.getWeapon() == null){
	    	
	    	if (c instanceof BladedCharacter && w instanceof Bladed) {
	    		c.equip(w);
		    	w.setOwned(true);
		    	System.out.println("\n" + w.getName() + "(" + w.getType() + ") is now equipped to " + c.getName() + "!");
	    	}
	    	
	    	else if (c instanceof RangedCharacter && w instanceof Ranged) {
	    		c.equip(w);
		    	w.setOwned(true);
		    	System.out.println("\n" + w.getName() + "(" + w.getType() + ") is now equipped to " + c.getName() + "!");
	    	}
	    	
	    	else if (c instanceof MagicalCharacter && w instanceof Magical) {
	    		c.equip(w);
		    	w.setOwned(true);
		    	System.out.println("\n" + w.getName() + "(" + w.getType() + ") is now equipped to " + c.getName() + "!");
	    	}
	    	
	    	else {
	    		System.out.println("\nError Equipping: Weapon Type does not match Character!");
	    	}
	  
	    	
	    }
	    else if (w.getOwned() == true)
	    	System.out.println("\nError Equipping: Weapon already equipped!");
	    else if (c.getWeapon() != null) {
	    	System.out.println("\nError Equipping: Character already has a Weapon!");
	    }
	  }

	  public void unequip(Character c){
		  c.unequip();
	  }

}
