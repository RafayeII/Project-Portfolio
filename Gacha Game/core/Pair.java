package core;

public class Pair {
	  private float multiplier;
	  private String combination;
	  private Character[] characters;
	  
	  
	  public Pair() {
		  characters = new Character[2];
	  }
	  
	  public Character[] getTeam() {
		  return this.characters;
	  }
	  
	  public void setTeam(Character c1, Character c2) {
		  this.characters[0] = c1;
		  this.characters[1] = c2;
		  
		  this.setCombinationMultiplier();
		  this.setCombination();
	  }
	  
	  public float getCombinationMultiplier() {
		  return this.multiplier;
	  }
	  
	  public void setCombinationMultiplier() {
		 // NORMAL PAIRING
		 if (this.characters[0].getElement() == this.characters[1].getElement()) {
			 this.multiplier = (float) 0.10;
		 }
	
     	// PERFECT PAIRING
		 else if ( (this.hasJoker() && this.hasCyclone()) || (this.hasTrigger() && this.hasLuna()) || (this.hasMetal() && this.hasHeat()) ) {
			 this.multiplier = (float) 0.75;
		 }

     	// NICE PAIRING
		 else if ( (this.hasJoker() && this.hasLuna()) || (this.hasJoker() && this.hasHeat()) ) {
			 this.multiplier = (float) 0.50;
		 }

     	// DECENT PAIRING
		 else if ( (this.hasJoker() && this.hasTrigger()) || (this.hasJoker() && this.hasMetal()) || (this.hasMetal() && this.hasCyclone()) || (this.hasMetal() && this.hasLuna()) ) {
			 this.multiplier = (float) 0.25;
		 }

     	// NO EFFECT
		 else if ( (this.hasTrigger() && this.hasMetal()) || (this.hasTrigger() && this.hasCyclone()) || (this.hasTrigger() && this.hasHeat()) ) {
			 this.multiplier = 0;
		 }

     	// BAD PAIRING
		 else if ( (this.hasCyclone() && this.hasLuna()) || (this.hasCyclone() && this.hasHeat()) || (this.hasLuna() && this.hasHeat()) ) {
			 this.multiplier = (float) -0.25;
		 }
	  }
	  
	  public String getCombination() {
		  return this.combination;
	  }
	  
	  public void setCombination() {
		  if (this.multiplier == 0.10) 
			  this.combination = "Normal";
		  

		  else if (this.multiplier == 0.75) 
			  this.combination = "Perfect";
		  
		
		  else if (this.multiplier == 0.50) 
			  this.combination = "Nice";
		  
		
		  else if (this.multiplier == 0.25) 
			  this.combination = "Decent";
		  
		
		  else if (this.multiplier == -0.25) 
			  this.combination = "Bad";
		  
		  else 
			  this.combination = "No Effect";

	  }
	  
	  public boolean hasJoker() {
		  for (int i = 0; i < 2; i++) {
			  if (this.characters[i].getElement() == "Joker")
				  return true;
		  }
		  
		  return false;
		  
	  }
	  
	  public boolean hasTrigger() {
		  for (int i = 0; i < 2; i++) {
			  if (this.characters[i].getElement() == "Trigger")
				  return true;
		  }
		  
		  return false;
		  
	  }
	  
	  public boolean hasMetal() {
		  for (int i = 0; i < 2; i++) {
			  if (this.characters[i].getElement() == "Metal")
				  return true;
		  }
		  
		  return false;
		  
	  }
	  
	  public boolean hasCyclone() {
		  for (int i = 0; i < 2; i++) {
			  if (this.characters[i].getElement() == "Cyclone")
				  return true;
		  }
		  
		  return false;
		  
	  }
	  
	  public boolean hasLuna() {
		  for (int i = 0; i < 2; i++) {
			  if (this.characters[i].getElement() == "Luna")
				  return true;
		  }
		  
		  return false;
		  
	  }
	  
	  public boolean hasHeat() {
		  for (int i = 0; i < 2; i++) {
			  if (this.characters[i].getElement() == "Heat")
				  return true;
		  }
		  
		  return false;
		  
	  }
	  
	  public int totalFinalWeaponPower(Weapon w1, Weapon w2) {
		  if (w1 != null && w2 != null)
			  return w1.finalWeaponPower() + w2.finalWeaponPower();
		  else if (w1 == null && w2 != null)
			  return 0 + w2.finalWeaponPower();
		  else if (w1 != null && w2 == null)
			  return w1.finalWeaponPower() + 0;
		  else
			  return 0;
	  }
	  
	  public int totalCharacterInfluence() {
		  return this.characters[0].characterInfluence() + this.characters[1].characterInfluence();
	  }
	  
	  public int characterSuperiority() {
		  return this.totalFinalWeaponPower(this.characters[0].getWeapon(), this.characters[1].getWeapon()) * (this.totalCharacterInfluence() / 10);
	  }
	  
	  public void levelPair(int levels) {
		  this.characters[0].increaseLevel(levels);
		  this.characters[1].increaseLevel(levels);
	  }
		
}
