package managers;

import core.Character;
import core.Resource;
import core.Weapon;
import others.ResourceChecker;

public class LevelManager{
	  
	  public void characterLevelUp(Character c, Resource r, int count){
	    ResourceChecker rchecker = new ResourceChecker();

	    if (rchecker.isResourceSufficient(count, r)){
		    if (c.getLevel() != 100) {
		    	for (int i = 1; i <= count; i++){
			        if (c.getLevel() < 100) {
			        	c.increaseLevel(1);
			        	r.decreaseAmount(1);
			        }
			    }
			    System.out.println('\n' + c.getName() + " is now Lv." + c.getLevel() + "!");
		    }
		    else 
		    	System.out.println("\nError Leveling: Level Already Maxed!");
		    
	    }
	    
	    else 
	    	System.out.println("\nError Leveling: Not Enough Resources!");
	    
	    	
	  }

	  public void weaponLevelUp(Weapon w, Resource r, int count){
	    ResourceChecker rchecker = new ResourceChecker();

	    if (rchecker.isResourceSufficient(count, r)){
		    if (w.getLevel() != 50) {
		    	for (int i = 1; i <= count; i++){
		    		if (w.getLevel() < 50) {
		    			w.increaseLevel(1);
		    			r.decreaseAmount(1);
		    		}
		    	}
		    	System.out.println('\n' + w.getName() + " is now Lv." + w.getLevel() + "!");
		    }
		    else 
		    	System.out.println("\nError Leveling: Level Already Maxed!");
		    
	    }
	    
	    else 
	    	System.out.println("\nError Leveling: Not Enough Resources!");
	    
	  }
	  
}