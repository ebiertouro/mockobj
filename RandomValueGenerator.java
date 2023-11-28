package mockObjects;
import java.util.*;

public interface RandomValueGenerator {

	public int NumGenerator(int min, int max);
	
	public boolean PercentageTrue(double probability);
}