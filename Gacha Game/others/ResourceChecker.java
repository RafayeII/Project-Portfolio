package others;

import core.Resource;

public class ResourceChecker{

	  public boolean isResourceSufficient(int cost, Resource r){

	    if (r.getAmount() >= cost)
	      return true;
	    else
	      return false;
	  }
}
