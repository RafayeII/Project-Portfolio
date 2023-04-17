package core;

public abstract class Weapon{
  protected String  name;
  protected int     power;
  protected int     rarity;
  protected int     level;
  protected boolean owned;

  public Weapon() {}

  public void increaseRarity(int amount){
	for (int i = 1; i <= amount; i++) 
		if (this.rarity <= 4) 
			this.rarity++;
  }

  public void increaseLevel(int levels){
	for (int i = 1; i <= levels; i++) 
		if (this.level <= 49) 
			this.level ++;
  }

  public String getName(){
	  return this.name;
  }

  public int getPower(){
	  return this.power;
  }

  public int getRarity(){
	  return this.rarity;
  }

  public int getLevel(){
	  return this.level;
  }

  public void setOwned(boolean value){
	  this.owned = value;
  }

  public boolean getOwned(){
	  return this.owned;
  }
  
  public abstract String getType();

  public float rarityMultiplier() {
	  if (this.getRarity() == 1) 
		  return (float) 0.7;
	  else if (this.getRarity() == 2) 
		  return (float) 0.8;
	  else if (this.getRarity() == 3) 
		  return (float) 0.9;
	  else if (this.getRarity() == 4) 
		  return (float) 1.0;
	  else if (this.getRarity() == 5) 
		  return (float) 1.2;
	  else if (this.getRarity() == 6)
		  return (float) 1.5;
	  else
		  return 0;
  }
  
  public int finalWeaponPower() {
	  return (int) ((this.getPower() * this.rarityMultiplier()) + this.level);
  }
  
}