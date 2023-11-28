package mockObjects;
import java.util.*;

public class IntRandom implements RandomValueGenerator {

	public int NumGenerator(int min, int max) {
		
		Random random = new Random();
	    return random.nextInt(max - min) + min;
		
	}
	
	public boolean PercentageTrue(double prb) {
		
		int c;
	      Random t = new Random();
	      c=t.nextInt(100);
	      if (c> prb){
	    	  return false;
	      }
	      else{
	    	  return true;
	    	  }
		
	}
}