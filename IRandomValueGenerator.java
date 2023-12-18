package mockObjects;

public interface IRandomValueGenerator {

	int NumGenerator(int min, int max);
	
	boolean PercentageTrue(double probability);
}