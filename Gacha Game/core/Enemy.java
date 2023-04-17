package core;

public class Enemy{
	  private String name;
	  private int    power;

	  public Enemy(String name, int power){
		  this.name = name;
		  this.power = power;
	  }
	  
	  public String getName(){
	    return this.name;
	  }

	  public int getPower(){
	    return this.power;
	  }
	  
}
