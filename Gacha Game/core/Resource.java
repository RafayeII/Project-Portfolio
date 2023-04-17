package core;

public class Resource{
	  private int amount;
	  
	  public Resource(int amount) {
		  this.amount = amount;
	  }
	  
	  public int getAmount(){
		  return this.amount;
	  }

	  public void decreaseAmount(int amount){
		  this.amount -= amount;
	  }

	  public void increaseAmount(int amount){
		  this.amount += amount;
	  }
}
