package managers;

import core.Character;
import core.Inventory;
import core.Weapon;

public class MergingManager{

	  public void mergeCharacters(Character c1, Character c2, Character c3, Inventory inventory){
		  
		  if (c1.getName() == c2.getName() && c1.getName() == c3.getName()) {
		
			  if (c1.getRarity() == c2.getRarity() && c1.getRarity() == c3.getRarity()) {
				  c2.unequip();c3.unequip();
				  c1.increaseRarity(1);
				  System.out.println('\n' + c1.getName() + " is now a " + c1.getRarity() + "-Rarity!");
				  inventory.disposeCharacter(c2); inventory.disposeCharacter(c3);
			  }
		    
			  else if (c1.getRarity() == 5) 
				  System.out.println("\nError Merging: Rarity Already Maxed!");
		    
			  else 
				  System.out.println("\nError Merging: Unequal Rarities!");
		    
		  }
	    
		  else 
			  System.out.println("\nError Merging: Characters are not the Same!");
	    
	  }

	  public void refineWeapons(Weapon w1, Weapon w2, Weapon w3, Inventory inventory){
		  
		  if ((w2.getOwned() != true && w3.getOwned() != true) && (w1.getName() == w2.getName() && w1.getName() == w3.getName())) {
			  
			  if (w1.getRarity() == w2.getRarity() && w1.getRarity() == w3.getRarity()) {
				w1.increaseRarity(1);
				System.out.println('\n' + w1.getName() + " is now a " + w1.getRarity() + "-Rarity!");
				inventory.disposeWeapon(w2); inventory.disposeWeapon(w3);
			  }
	    	
			  else if (w1.getRarity() == 5) 
		      System.out.println("\nError Merging: Rarity Already Maxed!");
	    	
			  else 
		      System.out.println("\nError Merging: Unequal Rarities!");
		  
		  }
	    
	    
		  else if (w2.getOwned() == true || w3.getOwned() == true) 
			  System.out.println("\nError Merging: Owned Material Weapon/s!");
		  
	    
		  else 
			  System.out.println("\nError Merging: Weapons are not the Same!");
	    
	  }
	  
}