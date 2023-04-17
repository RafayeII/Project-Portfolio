package core;

public class Map{
	  private String  locationName;
	  private int     resourceAmount;
	  private Enemy[] enemyList;

	  public Map(int mapNum) {
		  
		  if (mapNum == 1) {
			  this.setLocationName("Underground Caverns");
			  this.enemyList = new Enemy[7];
			  for (int i = 0; i < 1; i++) {
				  this.enemyList[i] = new Enemy("Elf", 224);
			  }
			  for (int i = 1; i < 7; i++) {
				  this.enemyList[i] = new Enemy("Slime", 73);
			  }
			  
			  this.setResourceAmount(53);
		  }
		  
		  else if (mapNum == 2) {
			  this.setLocationName("Forest of Enchantments");
			  this.enemyList = new Enemy[19];
			  for (int i = 0; i < 5; i++) {
				  this.enemyList[i] = new Enemy("Slime", 73);
			  }
			  for (int i = 5; i < 10; i++) {
				  this.enemyList[i] = new Enemy("Orc", 84);
			  }
			  for (int i = 10; i < 13; i++) {
				  this.enemyList[i] = new Enemy("Familliar", 144);
			  }
			  for (int i = 13; i < 16; i++) {
				  this.enemyList[i] = new Enemy("Faerie", 175);
			  }
			  for (int i = 16; i < 18; i++) {
				  this.enemyList[i] = new Enemy("Elf", 224);
			  }
			  for (int i = 18; i < 19; i++) {
				  this.enemyList[i] = new Enemy("Sorcerer", 313);
			  }
		      
			  this.setResourceAmount(77);
		  }
		  
		  else if (mapNum == 3) {
			  this.setLocationName("Sea of Hope");
			  this.enemyList = new Enemy[100];
			  for (int i = 0; i < 75; i++) {
				  this.enemyList[i] = new Enemy("Slime", 73);
			  }
			  for (int i = 75; i < 95; i++) {
				  this.enemyList[i] = new Enemy("Sorcerer", 313);
			  }
			  for (int i = 95; i < 100; i++) {
				  this.enemyList[i] = new Enemy("Hydra", 360);
			  }
			  
			  
			  
			  this.setResourceAmount(85);
		  }
		  
		  else if (mapNum == 4) {
			  this.setLocationName("Tower of Ether");
			  this.enemyList = new Enemy[32];
			  for (int i = 0; i < 20; i++) {
				  this.enemyList[i] = new Enemy("Basilisk", 499);
			  }
			  for (int i = 20; i < 27; i++) {
				  this.enemyList[i] = new Enemy("Harpy", 639);
			  }
			  for (int i = 27; i < 32; i++) {
				  this.enemyList[i] = new Enemy("Loki", 740);
			  }
			  
			  this.setResourceAmount(91);
		  }
		  
		  else if (mapNum == 5) {
			  this.setLocationName("Celestial Plane");
			  this.enemyList = new Enemy[80];
			  for (int i = 0; i < 50; i++) {
				  this.enemyList[i] = new Enemy("Faerie", 175);
			  }
			  for (int i = 50; i < 70; i++) {
				  this.enemyList[i] = new Enemy("Hyrdra", 360);
			  }
			  for (int i = 70; i < 80; i++) {
				  this.enemyList[i] = new Enemy("Loki", 740);
			  }
			  
			  this.setResourceAmount(100);
		  }
		  
	  }
	  
	  public String getLocationName(){
		  return this.locationName;
	  }
	  
	  public void setLocationName(String name) {
		  this.locationName = name;
	  }

	  public void setResourceAmount(int amount){
		  this.resourceAmount = amount;
	  }


	  public int getResourceAmount() {
	    return this.resourceAmount;
	  }
	  
	  public Enemy[] getEnemyList() {
	    return this.enemyList;
	  }
}
