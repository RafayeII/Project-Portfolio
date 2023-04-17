package core;

import java.util.Random;

import core.charactertype.*;
import core.weapontype.*;
import others.ResourceChecker;

public class GachaMachine {
	
	public Character singleCharacterPull(Resource r, int cost){
		ResourceChecker rchecker = new ResourceChecker();
		
		if (rchecker.isResourceSufficient(cost, r)) {
		    r.decreaseAmount(cost);
	    	int random1 = this.numberGenerator(3);
	    	int random2 = this.numberGenerator(40);
	    	Character pull;
	    	
	    	if (random1 == 1) //Bladed
	    		pull = new BladedCharacter(random2);
	    	else if (random1 == 2) //Ranged
	    		pull = new RangedCharacter(random2);
	    	else //Magical
	    		pull = new MagicalCharacter(random2);
	    		
		    System.out.println("\nYou pulled " + pull.getRarity() + "-Rarity " + pull.getName() + "(" + pull.getType() + ")!");
		    return pull;
	    }
	    
	    else {
	    	System.out.println("\nError Pulling: Not Enough Resources!");
	    	return null;
	    }
	    	
	  }

	public Character[] tenCharacterPull(Resource r){
		ResourceChecker rchecker = new ResourceChecker();
	    
	    if (rchecker.isResourceSufficient(2700, r)) {
		    r.increaseAmount(300);
	    	Character pulls[] = new Character[10];
		    
	    	for (int i = 0; i < 10; i++){
		      pulls[i] = this.singleCharacterPull(r, 300);
		    }
		    return pulls;
	    }
	    
	    else {
	    	System.out.println("\nError Pulling: Not Enough Resources!");
	    	return null;
	    }
	    
	  }
	
	public Weapon singleWeaponPull(Resource r, int cost){
		ResourceChecker rchecker = new ResourceChecker();
		
		if (rchecker.isResourceSufficient(cost, r)) {
			r.decreaseAmount(cost);
		    int random1 = this.numberGenerator(18);
		    int random2 = this.numberGenerator(60);
		    Weapon pull;
		    
		    if (random1 >= 1 && random1 <= 7) { //Bladed
		    	pull = new Bladed(random2);
		    	System.out.println("\nYou pulled " + pull.getRarity() + "-Rarity " + pull.getName() + "(" + pull.getType() + ")!");
		    }
		    else if (random1 >= 8 && random1 <= 11) { //Ranged
		    	pull = new Ranged(random2);
		    	System.out.println("\nYou pulled " + pull.getRarity() + "-Rarity " + pull.getName() + "(" + pull.getType() + ")!");
		    }
		    else if (random1 >= 12 && random1 <= 16) { //Magical
		    	pull = new Magical(random2);
		    	System.out.println("\nYou pulled " + (pull.getRarity() - 1) + "-Rarity " + pull.getName() + "(" + pull.getType() + ")!");
		    }
		    else {//Golden
		    	pull = new Golden(random2);
		    	System.out.println("\nYou pulled " + pull.getRarity() + "-Rarity " + pull.getName() + "(" + pull.getType() + ")!");
		    }
		    
		    return pull;
		}
		
		else {
	    	System.out.println("\nError Pulling: Not Enough Resources!");
	    	return null;
	    }
		
	  }
	
	public Weapon[] tenWeaponPull(Resource r){
		ResourceChecker rchecker = new ResourceChecker();
		  
		if (rchecker.isResourceSufficient(2700, r)) {
			r.increaseAmount(300);
			Weapon pulls[] = new Weapon[10];
	    
		    for (int i = 0; i < 10; i++){
		      pulls[i] = singleWeaponPull(r, 300);
		    }
		    return pulls;
		}
		
		else {
	    	System.out.println("\nError Pulling: Not Enough Resources!");
	    	return null;
	    }
		
	  }
	  
	public int numberGenerator(int maximum){
		Random number;
		number = new Random();return number.nextInt(maximum) + 1;
	}
	  
}