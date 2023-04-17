package core;

public abstract class Character{
	  protected String name;
	  protected int    rarity;
	  protected String element;
	  protected int    level;
	  protected Weapon equipment;

	  public Character() {}  

	  public void increaseRarity(int amount){
		for (int i = 1; i <= amount; i++) 
			if (this.rarity <= 4) 
				this.rarity++;
	  }

	  public void increaseLevel(int levels){
		for (int i = 1; i <= levels; i++) 
			if (this.level <= 99) 
				this.level ++;
	  }

	  public String getName(){
	    return this.name;
	  }

	  public int getLevel(){
	    return this.level;
	  }

	  public int getRarity(){
	    return this.rarity;
	  }

	  public String getElement(){
	    return this.element;
	  }

	  public Weapon getWeapon(){
		return this.equipment;
	  }
	  
	  public String getWeaponName() {
		return this.equipment.getName();
	  }
	  
	  public void equip(Weapon w){
	    this.equipment = w;
	  }
	  
	  public void unequip() {
		if (this.getWeapon() != null) {
			this.equipment.setOwned(false);
			this.equip(null);
		}
	  }
	  
	  public abstract String getType();
	  
	  public int characterInfluence() {
		return (int) (this.getLevel() * (1 + ((this.getRarity() - 1) / 5 )));
	  }
	  
}