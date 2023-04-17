package managers;

import core.*;
import core.Character;

public class AdventureManager {
	  private String success;


	  public int resourceObtained(Pair p, Character[] characters, int amount) {
		  int increase;
		  increase = (int) ((int)(amount + (int)(p.totalFinalWeaponPower(characters[0].getWeapon(), characters[1].getWeapon()) / 24)) * (int)(p.totalCharacterInfluence() / 36) * p.getCombinationMultiplier());
		  return (int)(amount + (int)(p.totalFinalWeaponPower(characters[0].getWeapon(), characters[1].getWeapon()) / 24)) * (int)(p.totalCharacterInfluence() / 36) + increase;
	  }

	  public void rewardSuccess(Pair p, Map m, Resource r) {

	    r.increaseAmount(this.resourceObtained(p, p.getTeam(), m.getResourceAmount()));
	    if (p.characterSuperiority() > this.enemySuperiority(m.getEnemyList())) {
	      this.success = "Successfully Completed";
	      p.levelPair(1);
	    }

	    else if ((p.characterSuperiority() / 2) > this.enemySuperiority(m.getEnemyList())) {
	      this.success = "Excellently Completed";
	      p.levelPair(2);
	    }
	    
	    else {
	      this.success = "Failed";
	    }
	    
	  }
	  
	  public String getSuccessType() {
		  return this.success;
	  }
	  
	  public int enemySuperiority(Enemy[] e) {
		    int sum = 0;
		    
		    for (int i = 0; i < e.length; i++)
		    	sum += e[i].getPower();
		    
		    return sum;
	  }
	  
}